import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Demo 
{
    public static void main(String[] args) 
    {
       Random r = new Random();
       List<Party> parties = Arrays.asList(Party.DEMOCRAT, Party.DEMOCRAT, Party.REPUBLICAN, Party.REPUBLICAN, Party.INDEPENDENT);

       System.out.println(parties.get(r.nextInt(parties.size())));
    }

    enum Party
    {
        DEMOCRAT,
        REPUBLICAN,
        INDEPENDENT;
    }
}