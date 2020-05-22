//Third Class
public class splitInput {

    public String splitFirstName(getInput input){

        String x = input.getFirstName();

        System.out.println(x);
        String[] splitValue = x.split("");

        String myValue = splitValue[2];

        return myValue;

    }
}