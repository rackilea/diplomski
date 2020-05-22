class Substring {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner user_input = new Scanner(System.in);
        String[] NameSplit = new String[3];
        String FirstName;
        String MiddleName;
        String LastName;

        System.out.println("Enter your full name (First Middle Last): ");
        String fullname = user_input.nextLine();

        NameSplit = fullname.split(" ");
        FirstName = NameSplit[0];
        MiddleName = NameSplit[1];
        LastName = NameSplit[2];

        System.out.println(fullname);
        System.out.println(LastName+ ", "+ FirstName +" "+ MiddleName);
        new StringBuilder(FirstName).reverse().toString();
        System.out.println(FirstName);
    }
}