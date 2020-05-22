public static void GetTextToFindAndFind(String textToFind, int ignorecase, int findCounter){
    // findCounter = 0 or 1. 0 represents find and 1 represents findCounter.
    String Current2 = textPane.getText();
    if(findCounter ==0){

        if(textToFind == null){
            optionPane.showMessageDialog(null, "Please Enter Text.", "Error", 0);
        }
        else if(textToFind.isEmpty()){
            optionPane.showMessageDialog(null, "Please Enter Text.", "Error", 0);
        }
        else{
            // Use any Character. But I a suggest to use a character from an Encrypted file.   
            Replacer = "¥";
            CurrentText = textPane.getText();
            if(ignorecase==1){
                CurrentText = CurrentText.toLowerCase();
                textToFind = TextToFind.toLowerCase();
            }
            int counter = 0;
            readtext = new StringReader(CurrentText);
            readBuffer = new BufferedReader(readtext);
            try {
                String Line = readBuffer.readLine();
                int found = 0;
                while(Line!=null || found != 1){
                    if(Line.contains(TextToFind)){
                        Line = null;
                        found = 1;
                    }
                    if(Line!=null){
                        Line = readBuffer.readLine();
                        counter = counter + 1;
                    }
                }
                if(found == 1){
                    textPane.setSelectionStart(CurrentText.indexOf(textToFind) - counter);
                    textPane.setSelectionEnd(CurrentText.indexOf(textToFind) + textToFind.length() - counter);
                    int counter2 = 1;
                    while(counter2!=textToFind.length()){
                        Replacer = Replacer + "¥";
                        counter2 = counter2 + 1;
                    }
                    CurrentText = CurrentText.replaceFirst(textToFind, Replacer);
                    findCounter = 1;
                            }
                else{
                    optionPane.showMessageDialog(null, "No Matches.", "Message", 0);    
                    }

                }
                catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  catch(NullPointerException e){
                optionPane.showMessageDialog(null, "No Matches.", "Message", 0);
            }
            }
        }

    else{
        int counter = 0;
        readtext = new StringReader(CurrentText);
        readBuffer = new BufferedReader(readtext);
        try {
            String Line = readBuffer.readLine();
            int found = 0;
            while(Line!=null || found != 1){
                if(Line.contains(textToFind)){
                    Line = null;
                    found = 1;
                }
                if(Line!=null){
                    Line = readBuffer.readLine();
                    counter = counter + 1;
                }
            }
            if(found == 1){
                textPane.setSelectionStart(CurrentText.indexOf(textToFind) - counter);
                textPane.setSelectionEnd(CurrentText.indexOf(textToFind) + textToFind.length() - counter);
                CurrentText = CurrentText.replaceFirst(textToFind, Replacer);
                        }
            else{
                optionPane.showMessageDialog(null, "No Matches.", "Message", 0);    
                }
            }
             catch(IOException e){
                e.printStackTrace();
            } catch(NullPointerException e){
                optionPane.showMessageDialog(null, "No Matches.", "Message", 0);    
                }
            }
    }