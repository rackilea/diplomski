Do this way: It might solve your problem:

public void Load(String fileName) throws FileNotFoundException{
        BufferedReader r = new BufferedReader (new FileReader(fileName));
        Scanner sc = new Scanner(r);
        while(sc.hasNextLine()){
            while(sc.hasNext()){
                String temp =sc.nextLine();

                if(temp.startsWith("Add")){
                    temp = temp.replaceAll("Add ", "");
                    String[] word = temp.split("\\s", 2);
                    Add(word[0], word[1]);       

                }else if(temp.equals("List")){
                    System.out.println("List");
                }
            }
        }
    }