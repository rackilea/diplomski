/**
         * This method divides the button text into lines by applying
         * html tags. Only way to get multiple lines on a JButton.
         * @param string
         * @return
         */
        private String wrapText(String string){
            //Return string initialized with opening html tag
            String returnString="<html>";

            //Get max width of text line
            int maxLineWidth = new ImageIcon("Images/buttonBackground.png").getIconWidth()-10;

            //Create font metrics
            FontMetrics metrics = this.getFontMetrics(new Font("Helvetica Neue", Font.PLAIN, 15));

            //Current line width
            int lineWidth=0;

            //Iterate over string
            StringTokenizer tokenizer = new StringTokenizer(string," ");
            while (tokenizer.hasMoreElements()) {
                String word = (String) tokenizer.nextElement(); 
                int stringWidth = metrics.stringWidth(word);

                //If word will cause a spill over max line width
                if (stringWidth+lineWidth>=maxLineWidth) {

                    //Add a new line, add a break tag and add the new word
                    returnString=(returnString+"<br>"+word);

                    //Reset line width
                    lineWidth=0;
                }else{

                    //No spill, so just add to current string
                    returnString=(returnString+" "+word);
                }
                //Increase the width of the line
                lineWidth+=stringWidth;
            }

            //Close html tag
            returnString=(returnString+"<html>");

            //Return the string
            return returnString;
        }