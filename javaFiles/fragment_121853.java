import java.util.ArrayList;
import acm.program.*;


public class ArrayListEx extends ConsoleProgram {


    public void init () {
       ArrayList<String> sList = new ArrayList <String>();

       readList (sList); 
       printList (sList);  

       readList (sList);  
       printList (sList);
   }


   private void readList (ArrayList list)  {
        while (true) {
            String line = readLine("Unesi tekst");
            if (line.equals("")) break;
            list.add(line);  
        }

    }

    private void printList (ArrayList lista) {

       println ("List contains: " + lista.size() + " elements.");

        for (int i = 0; i< lista.size(); i++) {

            println(lista.get(i));
        }

    }
}