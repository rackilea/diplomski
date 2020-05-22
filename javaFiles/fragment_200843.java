try{
    dropTables("DROP TABLE test;");
} catch (Exception e){
    e.printStackTrace();
} finally {
    con.close();
}