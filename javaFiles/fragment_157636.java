public static boolean checkID()
{
    try {
        Scanner y = new Scanner(new File("Names.txt")); // pass File instance
        while(y.hasNextLine())
        {
            final String idChecker = y.nextLine();
            if(idChecker.startsWith("ID: ") &&
               idChecker.substring(4).equals(String.valueOf(id)))
            {
                System.out.println(
                    "Sorry, this ID has already been taken, please try again.");
                y.close();
                return true;
            }
        }
        y.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return false;
}