ArrayList<Text> myText = new ArrayList<Text>();  
try
        {
            FileReader fr = new FileReader("score.txt");
            br = new BufferedReader(fr);


            String line;

            while((line = br.readLine()) != null)
            {
                //Splitting words so that I can print out ID, Name and Score
                //If i don't use split it just prints out score...because score gets written at last in file
                String[] words = line.split(",");

                for(int i =0; i<words.length; i++)
                {
Text temp = new Text();
                    temp.setText(words[i]);
temp.setStyle(TEXT_STYLE);
        temp.setFill(Color.WHITE);
myText.add(temp) //allows you to edit these later 
                    /*
                     * HERE IS THE PROBLEM
                     * Every time it reads line from text file
                     * I add it to gridPane below Header
                     * but i want to add rows dynamically but i get illegalArgumentException
                     */
                    gridPane.add(temp,2,i+1);
                }
            }


            br.close();

        }