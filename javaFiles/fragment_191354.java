public class ListObjects {
     private boolean checkEqual(List<Client> clientList){
         for(Client clientName : clientList) {
             if(clientName.name.equals("Tom") || clientName.name.equals("Jack")){
                 System.out.println("Validation success");
             }
         }
     }
}