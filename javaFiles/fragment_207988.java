Random r = new Random();

String alphabet = "123xyz";

// Prints 50 random characters from alphabet
for (int i = 0; i < 50; i++) 
{
    System.out.println(alphabet.charAt(r.nextInt(alphabet.length())));
}