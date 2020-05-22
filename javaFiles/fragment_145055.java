while (x < message.length())          
            {
                String text = message;
                String letter = Character.toString(text.charAt(x));
                x++;

                for(int i=0; i<letterA.length; i++)
                {
                    if(letter.equals(letterA[i]))if(letter.equals(letterA[i]))
                    {
                        System.out.print (letterB[i]);
                        break;
                    }
                    else if (letter.equals(" "))
                    {
                        System.out.print(" ");
                        break;
                    }
                }
            }