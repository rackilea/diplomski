public class Test
{
    public static void main(String[] args)
    {
        String input = "asdf123**";
        String output = input.replaceAll("[^1a*]", "");
        System.out.println(output); // Prints a1**
    }
}