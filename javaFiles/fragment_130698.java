/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.time.* ;
import java.time.format.* ;
import java.time.temporal.* ;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {

List< DateTimeFormatter > formatters = 
    List.of(
        DateTimeFormatter.ofPattern( "MM-dd-uuuu" ) ,  // 01-23-2019
        DateTimeFormatter.ISO_LOCAL_DATE ,             // 2019-01-23
        DateTimeFormatter.ofPattern( "uuuu/MM/dd" )    // 2019/01/23
    )
;

List< String > inputs = 
    List.of(
        "01-23-2019" , 
        "2019-01-23" ,
        "2019/01/23" ,
        "banana"
    )
;

for( String input : inputs ) {
    LocalDate localDate = null ;
    for( DateTimeFormatter formatter : formatters ) 
    {
        try{
            localDate = LocalDate.parse( input , formatter ) ;
        } catch ( DateTimeParseException e ) {
            // Ignoring exception, as it is expected. 
        }
    }
    if( Objects.isNull( localDate ) ) 
    { // Deal with unexpected input 
        System.out.println( "ERROR: Unexpected input: " + input ) ;
    } else {
        System.out.println( "Input: " + input + " ➙ " + localDate.toString() ) ;
    }
}



    }
}