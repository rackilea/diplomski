public class Example {
    public static void main(String[] args) {
         try{
             File file = new File("C:/ProgramData/Logs/" + selectedJLItem);

             if(file.delete()){
                 System.out.println(file.getName() + " Was deleted!");
             }else{
                 System.out.println("Delete Operation Failed. Check: " + file);
             }
         }catch(Exception e1){
             e1.printStackTrace();
         }    
    }
}