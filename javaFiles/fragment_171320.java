try{
        BufferedReader reader = new BufferedReader(new FileReader("file.txt")); //try with resources needs JDK 7

        boolean doRegex = false;
        String readLine;
        while ((readLine = reader.readLine()) != null) { //read until end of stream
            if(readLine.startsWith("~~ End of Syllabus")){                  
                doRegex = true;
                continue;   //immediately goto the next iteration
            }
            if(doRegex){
                String[] line = readLine.split(" "); //split on spaces
                if(line[0].matches("your regex here")){
                      //answer should be line[1]
                      //do logic with your answer here
                }                   
            }
        }
    } catch (IOException e) {
        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }