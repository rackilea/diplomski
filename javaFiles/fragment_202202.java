public class ShuffleList {
           public static void main(String args[]) {
           // create an array list object       
           List myList = new ArrayList();

           // populate the list
           myList.add("A");
           myList.add("B");
           myList.add("C"); 
           myList.add("D");
           myList.add("E"); 

           System.out.println("Collection after: "+ myList);

           // shuffle the list
           Collections.shuffle(myList);

           System.out.println("Collection after shuffle: "+ myList);
           }    
        } 

After compiling the program, the output is:

Collection before shuffle: [A, B, C, D, E]
Collection after shuffle: [C, A, E, B, D]