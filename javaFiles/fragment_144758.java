public void login()
    {
        ArrayList<String> loginUser=new ArrayList<>();
        String name = JOptionPane.showInputDialog(null, "Enter User Name:");
        String password = JOptionPane.showInputDialog(null, "Enter User Password:");
        try {
            FileReader fr=new FileReader("C:\\Users\\Desktop\\outputFile.txt");
            BufferedReader br=new BufferedReader(fr);
            String st;
            while ((st = br.readLine()) != null)
            {
                // This changed
                String[] credentials = st.split(" ");
                for (String credential : credentials) {
                    loginUser.add(credential);
                }
            }
            br.close();
            fr.close();
        }
        catch(IOException e)
        {
            System.out.println("File not found");
        }

        // This for block changed
        for (int i = 0; (i + 1) < loginUser.size(); i += 2) {
            String uname = loginUser.get(i);
            String pass = loginUser.get(i + 1);
            if (uname.equals(name) && pass.equals(password)) {
                JOptionPane.showMessageDialog(null, "Welcome to Rent A Car ");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Wrong login info please try again");
    }