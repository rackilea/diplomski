package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T { 
    static int count=0;     
    public static void main(String[] args) {    
        List<String> list = new ArrayList<String>();

       // for testing purpose only i am making this list and putting this data
        for (int i = 101; i < 501; i++) {
            list.add(i + "");
        }
        boolean matchedSuffix = false;
        String prefix = "30";

        Collections.sort(list);

        int startFrom = T.binarySerchOverList(list, prefix);

        if (startFrom == -1) {
            System.out.println("no data found");
        } else {
                for (int i = startFrom;; i++) {
                String s = list.get(i);
                if (s.startsWith(prefix)) {                     
                    //here you will get matching strings                    
                    System.out.println(s);
                    matchedSuffix = true;
                } else {
                    if (matchedSuffix) {
                        break;
                    }
                }

            }
        }    
    }

    public static int binarySerchOverList(List<String> input, String prefix) {    
        count++;
        System.out.println( "iteration count is "+count);       
        int size = input.size();
        int midpoint = size / 2;
        int startPoint = 0;

        String stringToTest = input.get(midpoint);
        if (stringToTest.startsWith(prefix)) {
            startPoint = midpoint - 1;
            while (true) {

                if (!input.get(startPoint).startsWith(prefix)) {
                    startPoint++;
                    break;
                }
                if (startPoint == 0) {
                    break;
                }   
                startPoint--;
            }   
            return startPoint;
        }

        if (stringToTest.compareTo(prefix) > 0) {
            List<String> sublist = input.subList(0, midpoint);
            return binarySerchOverList(sublist, prefix);
        }

        if (stringToTest.compareTo(prefix) < 0) {    
            if (input.get(input.size() - 1).compareTo(prefix) < 0) {
                return -1;
            }
            List<String> sublist = input.subList(midpoint, input.size());
            return binarySerchOverList(sublist, prefix);
        }    
        return 0;    
    }    
}