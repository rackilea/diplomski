import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author blj0011
 */
public class JavaApplication24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<PersonValueObject> data = new ArrayList();
        data.add(new PersonValueObject("Tom", 1));
        data.add(new PersonValueObject("Tom", 2));
        data.add(new PersonValueObject("Alex", 4));

        Map<String, Integer> result = data.stream().collect(Collectors.groupingBy(PersonValueObject::getName, Collectors.summingInt(PersonValueObject::getValue)));

        for (Map.Entry<String,Integer> entry : result.entrySet())  
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue()); 
    }         
}