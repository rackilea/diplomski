String[] foods = ...;
int remain = foods.length;
int start = 0;
while(remain > 0)
{  if (remain >= 100)
     executeBatch(foods, start, 100); start+=100; remain-=100;
   else if (remain >= 30)
     executeBatch(foods, start, 30); start+=30; remain-=30;
   else {
     executeBatch(foods, start, 1); start+=1; remain-=1;
   }
}


void executeBatch(String[] f, int off, int len)
{
    StringBuilder sqlBuf = StringBuilder("... IN(");
    for(int i=0;i<len;i++) {
        sqlBuf.append((i!=0)?",?":"?");
    }
    String sql = sqlBuf.append(") AND exp < ?").toString();
    PreparedStatement ps = c.prepareStatement(sql);
    for(int i=0;i<foods.length;i++)
        ps.setString(i+1, foods[i+off]);
    ps.setTimestamp(foods.length+1, now);
    ....
}