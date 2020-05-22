import java.util.Scanner;

public class ObjectInstanceMethodExample {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        FirstGirlfriend firstGF = new FirstGirlfriend();
        System.out.println("Enter name of first gf here: ");
        String temp = input.nextLine();
        firstGF.setName(temp);
        firstGF.sayFirstGirlfriendName();
    }
}

class FirstGirlfriend {
    private String girlName;
    public void setName (String name){
        girlName=name;
    }
    public String getName (){
        return girlName;
    }
    public void sayFirstGirlfriendName(){
        System.out.printf("Your first gf was %s", getName());
    }
}