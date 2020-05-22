String param = "aa,bb,cc";
String str = 
     "select column_val from table_name where a = '?' and b = '?' and c = '?'";

@Test
public void Substitute(){
    StringBuilder builder=new StringBuilder(str);

    String[] params = param.split(",");
    int position=0;
    for (String paramValue:params){
        position=builder.indexOf("?",position);
        if (position==-1)
            throw new RuntimeException("too parameter values specified.");
        builder.replace(position,position+1,paramValue);
        position++;
    }
    position=str.indexOf("?",position);
    if (position!=-1)
        throw new RuntimeException("Not all parameter specified.");

    Assert.assertEquals(builder.toString(),
          "select column_val from table_name where a = 'aa' and b = 'bb' and c = 'cc'");

}