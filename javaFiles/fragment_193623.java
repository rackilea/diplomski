public static List<String> parseCode() {
    List<String> inputList = new ArrayList<String>(); 

    String File = "Sample1.txt";
    String line = null;
    try
    {
        FileReader fr = new FileReader(File);

        BufferedReader br = new BufferedReader(fr);
        String add = "";

        boolean comment = false;
        while((line = br.readLine()) != null)
        {
            String [] s = line.split(" ");
            for(int i = 0; i < s.length; i++)
            {
                if(s[i].contains("/*"))
                {
                    comment = true;
                }       

                if(!comment)
                {
                    add += s[i];
                    if(i < s.length-1 && add.length() > 0)
                    {
                        add += " ";
                    }

                }

                if(s[i].contains("*/"))
                {
                    comment = false;
                }
            }
            if(add.length() > 0)
            {
                inputList.add(add);
            }
        }
        br.close();
    }
    catch(FileNotFoundException E)
    {
        System.out.println("File Not Found");
    }
    catch(IOException E)
    {
        System.out.println("Error Reading File  Sample1.txt");
    }
    return inputList;
}