public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            String area, inStr;  //there is no need of inStr as you are not using it so remove it if not used
            int pages;

            System.out.println("Please enter your city");
            area = input.nextLine();

            System.out.println("Please enter page number " + area + "'s phone book");
            pages = input.nextInt();

            PhoneBook phoneBook = new PhoneBook(pages,area); //swapp the argurments
              phoneBook.display(pages, area); //add arguments to this otherwise it will just show 0 
        }