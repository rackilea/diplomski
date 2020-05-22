public class main {
public static StringBuffer inString;

public main()
{
inString = new StringBuffer("Our aim is to make a 15 realistic game, where grinding powerlines and doing a tailwhip isn't easy, like in the real world. A game in which you will feel like you're actual riding. A game in which creativity and beauty are combined. ");
inString = new StringBuffer(inString.toString().replaceAll(" +", " "));
new MyClass();
}
public static void main(String[] args) {
    new main();
    }
}