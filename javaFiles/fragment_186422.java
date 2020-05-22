package collectionCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.SynchronousQueue;

public class TestCollections {

public static void main(String[] args) {

    //String a = "9:50 PM,12:25 PM,3:55 PM,10:15 PM,1:15 PM";
    String a = "9:50 PM,12:25 PM,3:55 PM,10:15 PM,1:15 PM,1:00 AM, 12:25 AM, 10:13 AM";
    List<String> al2 = new ArrayList<>();
    List<Float> al3 = new ArrayList<>();
    List<String> al4 = new ArrayList<>(); // list of final results to display
    String arg[] = a.split(",");
    // System.out.println(arg);
    // Collections.sort(list);
    List<String> al = new ArrayList<String>();
    al = Arrays.asList(arg);
    for (String s : al) {
        System.out.println(s);
        s  = s.trim(); // remove leading and trailing spaces, otherwise the conversion to float will fail
        s = s.replace("12:", "00:"); // do not forget 12:00 is like 00:00 and 12:00 AM/PM is least than 1:00 AM/PM
        String[] t = s.split(" ");
        String ampm = t[1]; // extract AM/PM
        System.out.println("ampm "+ ampm );
        if( ampm.toUpperCase().equals("PM")) {
            String h = t[0].split(":")[0]; // extract hours
            int hh = 12 + Integer.parseInt(h); // add 12 for PM
            t[0] = t[0].replace(h+":", hh+":");
        }

        al2.add(t[0].replace(":", "."));
    }
    System.out.println(al2);
    Iterator li = al2.iterator();
    while (li.hasNext()) {
        String s = (String) li.next();
        float no = Float.parseFloat(s);
        System.out.println(" s -> no : "+ s +" -> "+ no);
        al3.add(no);
    }

    Collections.sort(al3);
    ListIterator lit = al3.listIterator();
    while (lit.hasNext()) {

        float f = (Float) lit.next();
        int intno = (int) f;
        if(intno < 12 ) {
            int hour12 = intno == 0 ? 12 : intno; // replace 00:xx am by 12:xx am
            al4.add(hour12 +":"+ ((int)((f-intno)*100)) +" AM");
        }
        else {
            al4.add((intno-12)+":"+ ((int)((f-intno)*100)) +" PM");
        }
    }
    System.out.println(al4);
}
}