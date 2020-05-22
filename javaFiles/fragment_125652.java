public class Utils {

    public static String selectQuery = "SELECT EMPNAME FROM EMPLOYEEDETAILS";
    public static void dbSelect(String query) throws InterruptedException, ExecutionException, SQLException{
        ExecutorService service=Executors.newFixedThreadPool(1);
        Callable<List<String>> callable = new SelectThreadClass();

        Future<List<String>> future = service.submit(callable);

        List<String> empList = future.get();
        for(String emp : empList){
            System.out.println(emp);
        }
    }

    public static void main(String args[]) throws InterruptedException, ExecutionException, SQLException{
        dbSelect("SELECT EMPNAME FROM EMPLOYEEDETAILS");
    }

}