public static void main(String[] args) {

            int num_of_elements;
            Scanner sc = new Scanner(System.in);
            System.out.println("\nenter a value for number of elements");

            while((num_of_elements = sc.nextInt())<0)
            {
                System.out.println("\nenter a positive value ");
            }
            //num_of_elements = sc.nextInt();
            System.out.println("\n"+ num_of_elements);

            int[] array_booleans = new int[num_of_elements];
            int[] array_integers = new int[num_of_elements];

            /*String bool_file;
            System.out.println("\nEnter the name of the file with the booleans");
            bool_file = sc.nextLine();*/
            String int_file;
            System.out.println("\nEnter the name of the file with the integers");
            int_file = sc.next();


            try {
                File f  = new File(int_file);
                Scanner scanner = new Scanner(f);
                int i=0;
                while( i<array_integers.length){

                   array_integers[i++]= scanner.nextInt(); 
                }


            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            for(int i=0;i<array_integers.length;i++)
                System.out.println(array_integers[i]+ " ");



    }