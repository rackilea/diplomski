String sql2 = "select phone_no from users where region in (";
for( int i=0; i<areaList.length ; i++){
    sql2 += "\'"+ areaList[i]+"\'";
    if (i<areaList.length-1)
        sql2+=",";
}
sql+=")";

result = statement.executeQuery(sql2);

while(result.next()){
        String numbers = result.getString(1);
        //System.out.println(numbers);
}