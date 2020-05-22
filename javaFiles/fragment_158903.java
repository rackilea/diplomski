public static void main(String[] args) 
 {
     try (ExecutorCloseable ec = new ExecutorCloseable ()) 
     {

        ec.execute();

     } catch(Exception e){
        //...
     } finally {
       //...
    }
 }