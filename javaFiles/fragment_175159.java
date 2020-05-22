String line = "n number 1";
            String JAVASCRIPTTextToWrite="";
            if(line.contains("n"))
            {
                //split the line with space
                String[] LineSplit = line.split(" ");

                if(LineSplit[0].contains("n"))
                {
                    //split the already split line  with "n thename "
                    String[] LineSplit2 = line.split("n " + LineSplit[1] + " ");
                    System.out.println( LineSplit[1]);
                    System.out.println( LineSplit2[0]);
                    String text = "var " + LineSplit[1] + "=" + LineSplit2[1] +  ";";
                    text = text.replace("\n", "").replace("\r", "");

                    JAVASCRIPTTextToWrite += text;
                    System.out.println(JAVASCRIPTTextToWrite);
                }

            }