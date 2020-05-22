public static void main(String test[]) {

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int AddName = 0;

        do  {

            System.out.print("Do you want to add a new name (Y/N)");
            String newname = scanner.next();

            if (newname.equalsIgnoreCase("y")) {

                System.out.println("Enter first name: ");
                String fname = scanner.next();

                System.out.println("Enter last name: ");
                String lname = scanner.next();

                AddName = AddName + 1;

            }

            else if (newname.equalsIgnoreCase("n")) {

                System.out.println("Goodbye");
                AddName = AddName + 3;
            }

        } while (AddName < 3);
    }