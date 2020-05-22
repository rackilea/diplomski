import java.util.List;
import java.util.ArrayList;

// Test
String serialized_string = "foo|bar|coco123||cool|||";

// Split the test
String[] raw_results=serialized_string.split("\\|");// Trailing empty strings are removed but not internal ones

// Cleansing of the results
List<String> php_like_results = new ArrayList<String>();
for(String tmp : raw_results) {
    if (tmp.length()>0) {
       php_like_results.add(tmp);
    }
}

// Output results
System.out.println(php_like_results);