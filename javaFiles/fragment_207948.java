public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in);
    List <String> Vowels = new ArrayList<String>();
    System.out.println("What is your string? ");
    String abc = sc.nextLine();
    int n = abc.length();
    for(int i=0; i < n ; i++)
    {
        Vowels.add(new StringBuilder().append("").append(abc.charAt(i)).toString());
    }

    for(int j=0; j< Vowels.size();j++)
        System.out.print(Vowels.get(j));
}