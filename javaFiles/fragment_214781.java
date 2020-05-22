import java.util.*;
public class HelloWorld{
public static void main( String[] args){
System.out.println( "Hello World");
String input = "test2, abc0001, abc0002, abc002, efg00113, efg00114, efg00115, rtasdf1, test123";
String[] result = input.split( ", ");
List<String> output = new ArrayList<String>();
int toMerge = 0; // <------>
for( int i = 0; i < result.length; ++i){ // <----------
    if( i == result.length - 1){
        if( toMerge != 0){
            result[ i] = result[ i - toMerge] + "-" + result[ i];
            output.add( result[ i]);
            toMerge = 0;
        }
        else{
            output.add( result[ i]);
        }
        break;
    } // ----------->
    String[] first = result[ i].split( "(?<=\\D)(?=\\d)");
    int digits1 = Integer.parseInt( first[ 1]);
    String[] second = result[ i + 1].split( "(?<=\\D)(?=\\d)");
    int digits2 = Integer.parseInt( second[ 1]);
    if( second[ 0].equals( first[ 0]) && (second[ 1].length() == first[ 1].length()) && ((digits2 - digits1) == 1)){
        toMerge++; // <--------
    }
    else{
        if( toMerge != 0){
            result[ i] = result[ i - toMerge] + "-" + result[ i];
            output.add( result[ i]);
            toMerge = 0;
        }
        else{
            output.add( result[ i]); // --------->
        }
    }
}
    String[] out = output.toArray( new String[ output.size()]);
    for( String a : out)
        System.out.println( a);

    // Arrays.sort(result);
    // for(String a : result)
    // System.out.println(a);

}
}