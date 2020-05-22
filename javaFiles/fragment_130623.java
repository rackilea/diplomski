public static void main (String[] args)
{
    Scanner in = new Scanner(System.in);
    List<String> typeString;
    while(in.hasNext()) {
        String[] str = in.nextLine().split("=");
        System.out.println("Size: " + str[1].split(" ")[0] + " Type: " + str[2]);
        typeString = new ArrayList<>(Arrays.asList(str[2].split(", ")));
    }
}