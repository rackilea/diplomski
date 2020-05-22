public static void main (String args[]) 
    {
        String input;
        Scanner scanner = new Scanner(System.in);
        List<Object> listOfObject = new ArrayList<>();
        do
        {
            System.out.println("Computer Menu");  
            System.out.println("1. Add a new Desktop Information");
            System.out.println("2. Add a new Laptop Information");
            System.out.println("3. Display all Computer Information");
            System.out.println("4. Quit");

            System.out.print("Please enter either 1 to 4: "); 
            input =(scanner.nextLine());
            if (input.equals("1")){
                Desktop desktop1 = new Desktop();
                listOfObject.add(desktop1);
            }else if (input.equals("2")){
                Laptop laptop1 = new Laptop();
                listOfObject.add(laptop1);
             }else if(input.equals("3")){
                 for(Object obj : listOfObject){
                     if(obj instanceof Desktop){
                        Desktop d1 = (Desktop)obj;
                        System.out.println(d1.toString());
                     }else if(obj instanceof Laptop){
                         Laptop l1 = (Laptop)obj;
                         System.out.println(l1.toString());
                     }
                 }
             }
        }while(!input.equals("4"));
    }