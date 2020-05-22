int listSize = al.size();

for(int i = 0; i < listSize; i++) {         
    ResultSet rs1 = name.executeQuery("SELECT sum(hours) FROM PROJECT_TIME WHERE DATE = '"+date+"' AND name = '"+al.get(i)+"'");
    while(rs1.next()){
        al1.add(rs1.getString(1));
    }
    rs1.close();

}
System.out.println(al1);