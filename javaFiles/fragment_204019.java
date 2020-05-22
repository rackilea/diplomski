int[] counts = new int[26];
       for (short i = 0; i < (input).length(); i++)

       {
                char temp = Character.toLowerCase((input).charAt(i));
                if (temp >= 'a' && temp <= 'z')
                    counts[temp - 'a']++;
       }


       for (short i = 0; i < counts.length; i++)
       {
               output += (char) ('a' + i) + ":\t " + counts[i] + "\n";
       }

       int count = 0;
       for (short i = 0; i < (input).length(); i++)
       {
                if ((input).charAt(i) == 'a' || (input).charAt(i) == 'A')
                    count++;
       }

       output += "" + count;
       txaResults.setText(output);