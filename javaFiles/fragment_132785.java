import static map.Main.stringToInt;
import java.util.*;
rule "int from map"
when
  $list : List(size > 0 ) 
  $m1 : Map() from $list.get(0)
  $var1 : Map(stringToInt(this["number"]) > 0 ) from $list.get(0)
then
  System.out.println( "got 4711" );
end