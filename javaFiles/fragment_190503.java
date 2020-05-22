public String[] files() 
    throws FileNotFoundException
{
   List<String> existingUsers = new ArrayList<String>();
   File users = new File("username.txt");
   Scanner sc = new Scanner(users);
   while (sc.hasNext()) {
       existingUsers.add(sc.nextLine());
   }
   return existingUsers.toArray(new String[existingUsers.size()]);
 }