ExecutorService service=Executors.newFixedThreadPool(1);
Callable<ResultSet> callable = new SelectThreadResultSet();
Future<ResultSet> future = service.submit(callable);
ResultSet rs = (ResultSet)future.get();
// Here I dont get any values
while(rs.next()){
    System.out.println(rs.getString("EMPLOYEE"));
}