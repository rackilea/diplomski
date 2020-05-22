static boolean checkUsername(String u) throws IOException { //We use this function when registering a user, to make sure they don't already exist
        boolean userFound = false; //Our boolean for if the user exists
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./loginData.dat")); //Load our loginData.dat file into the buffer
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (String line = br.readLine(); line != null; line = br.readLine()) { //Read the file line by line
            String[] userDataNew=line.toString().split("\\|"); //Split our line up into an array using |

            if(userDataNew[0].equals(u)) { //We've found their username already
                userFound = true; //Set our user found bool to true
                break; //Break out of the foor loop
            }
        }
        return userFound; //Return true/false 
}