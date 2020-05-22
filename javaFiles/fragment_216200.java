String file = "text.txt";
    BufferedReader br = null;
    int nbAnswer = 4;
    try {
        br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null) {   
            if( line.contains("-----------"))
            {
                line = br.readLine();
                String question = line.split("#[0-9]{4} ")[1];
                while(!(line = br.readLine()).contains("-----------"))
                    question += " " + line.trim();

                String[] answers = new String[4];

                for( int i = 0; i < nbAnswer; i++)
                    answers[i] = br.readLine().substring(2);

                br.readLine();
                String sol = br.readLine().split("Answer: ")[1];
                System.out.println(question + "\nanswer: " + answers[0] + " " + answers[1] + " " + answers[2] + " " + answers[3] + "\nsol " + sol);
            }
        }
    }
    catch(IOException ex) {
        System.err.println(ex);
    }