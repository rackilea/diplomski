public void readFile(String fileName)throws IOException
    {
        Scanner input = null;
        input = new Scanner(new BufferedReader(new FileReader(fileName)));
        String userInput;
        try
        {
            while (input.hasNextLine())
            {
                userInput = input.nextLine().trim();
                if (userInput.length() > 0)
                {
                    String[] userInfo = userInput.split(":");
                    int count = Integer.parseInt(userInfo[0].trim());
                    String name = userInfo[1].trim();
                    int id = Integer.parseInt(userInfo[2].trim().split("\\s+")[1].trim());
                    int age = Integer.parseInt(userInfo[3].trim().split("\\s+")[1].trim());

                    System.out.println("Count: " + count + " Name: " + name + " ID:" + id + " Age:" + age);
                }
                Fighters newFighters = new Fighters(id, name, age);
                fighterList.add(newFighters);
            }


        }
        finally
        {
            if (input != null)
            {
                input.close();
            }
        }
    }