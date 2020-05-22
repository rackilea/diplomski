public class YourTicketsClass {

    //declare ArrayList as an instance variable
    ArrayList<String> theDateArray= new ArrayList<>();

    public ArrayList<String> getTicketDates(){
        int i;
        for (i=0; i <tickets.size(); i++){
            if(tickets .get(i).getPurchased()== false){
                 theDateArray.add(tickets.get(i).getDate());
            }
        }
        for(int f=0; f<theDateArray.size();f++){
           System.out.println(theDateArray.get(f)+ " ");
        }
        return theDateArray;
    }       

    public int getTickets(String date){
         int tix= theDateArray.indexOf(date);
         int occurrences= Collections.frequency(theDateArray, tix);
         if (tix>=0){
             System.out.println(occurrences);
         }
        return occurrences;
   }
}