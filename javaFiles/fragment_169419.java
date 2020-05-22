// imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// sample code
String[] str = {"16","b","c","d","e","16","f","g","16","b"};
List<String> list = Arrays.asList(str); // List from the array
List<String> newList = new ArrayList<String>();
for(String myStr : list){
    if(list.indexOf(myStr) == list.lastIndexOf(myStr)){
        /*
         * This is a unique element as its index and lastIndex in list are same.
         * Add it to new list.
         */
        newList.add(myStr);
    }
}
// Freeing resources
str = null;
list = null;

System.out.println("Final List: "+ newList);