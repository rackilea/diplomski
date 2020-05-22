public static void main(String[] args) {
        BufferedReader reader = null;
        String line;
        String name,pwd,contactNo,email;
        try {
            reader = new BufferedReader(new FileReader("src/files/temp2.txt"));
            String foundWord = "dod";
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(",");
                for (String word : words) {
                    if (word.equals(foundWord)) {
                        name = words[0];
                        pwd = words[1];
                        contactNo = words[2];
                        email = words[3];
                        System.out.println("Details: " +name + "-" + pwd + "-" + contactNo + "-" + email);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
             reader.close()
        }
    }