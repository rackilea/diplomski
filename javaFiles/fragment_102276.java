@Override
public void batchUpt2(User_FK users) {


    long startTime = System.nanoTime(); 
    for(int i = 0; i < users.getUser().size(); i++) {
        jdbcTemplate.update("INSERT INTO INS_RAZNO.BULK_TEST VALUES (?, ?, ?)", new Object[] {
            i+1, users.getUser().get(i), 1  
        });
    }
    long endTime = System.nanoTime();
    long duration = (endTime - startTime) / 1000000;
    System.out.println("-------------"+duration+"-----------------forEach");

}