void validateUser() throws Exception{
            BufferedReader getIt = new BufferedReader(new InputStreamReader(System.in));
            String userName = "";

            try{ 
                FileInputStream fstream = new FileInputStream("../FTPServer/userInfo.txt");

                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strLine;

                System.out.println("Enter your username");
                userName = getIt.readLine();

                while ((strLine = br.readLine()) != null){
                    if (userName.equals(strLine)){
                        System.out.print("Successful Login\n");
                        displayMenu();
                    }
                }

                 System.out.println("Invalid Username");
                        userBack();

                in.close();
            }   catch (Exception e) {//Catch exception if any
            System.out.println("\nError in validate user");
        }