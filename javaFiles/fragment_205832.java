//once a space was found and the while loop broken, add a index to begin reading the severed word completely
            temp++;
            cutWord = "";
            //this while loop makes sure to read until it comes across another space or reaches the end of the string (in the even that this cut word happens to be the final word)
            while(cutChar != ' ' && sentence.length() >= temp){
                //examines the chars in the sentance, adds it to the cut word, and increases the index
                cutChar = sentence.charAt(i);
                cutWord += cutChar;
                temp++;
                if (temp >= 40){
                    //counts the additional indexes to be added to the normal index when resumed
                    cutAdd++;
                }
            }

            //after exiting the loop, the string "cutWord" should be the full word cut between the two lines

            //adds the new line (minus the chars taken for the cut word) 
            words.add(newLine);
            //starts a new line with cutWord being the start
            newLine += cutWord;
            //increases index by amount of new characters
            i += cutAdd;

            //resets the cut variables
            cutWord = "";
            cutAdd = 0;