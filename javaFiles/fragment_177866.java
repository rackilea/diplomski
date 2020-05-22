ResultSet rs = stmt.executeQuery(query);
if(!rs.isBeforeFirst()){
    System.out.println("result set is empty");
}
else {
    System.out.println("Result set is not empty");
}