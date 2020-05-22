public void displayFileInJLabel(JLabel label, String filePath) {
    try {
        // Try With Resources (will auto close the reader).
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            /* We use StringBuilder to build our HTML Wrapped 
               string to display within the JLabel.  */
            StringBuilder sb = new StringBuilder();

            // Get the width of our supplied JLabel
            int w = label.getWidth();

            /* Calculations for determininfg Line Wrap. 
               The (w / 4) is a modifiable offset.  */
            String width = String.valueOf((w - (w / 4))); 

            /* Deal with Line Wrap (JLabels don't do this) and
               set up Left Padding.  */
            sb.append("<html><body style='width: ").append(width).append("px; padding:10px;'>");

            /* Apply the Title Center of JLabel, Blue Color Text, 
               and Bold Font Style.The size of the text is determined 
               by the <h1> and </h1> tags.  */
            sb.append("<center><h1><font color=blue><b>").append(filePath).append("</b></font></h1></center><br>");

            // Read in File Lines one at a time.
            String line;
            while((line = reader.readLine()) != null) {
                /* Deal with multiple whitespaces (basic indenting etc) since HTML 
                   doesn't deal well with more than a single whitespace.  */
                line = line.replaceAll("\\s{4}", "&nbsp;&nbsp;&nbsp;&nbsp;");

                /* Deal with line breaks. JLabels won't deal with them since 
                   it is designed for a single line of text. We therefore
                   apply the HTML Line Break tag (<br>)at the end of each 
                   text file line to take care of this business.   */
                line+= "<br>";

                sb.append(line);
            }

            // Apply the closing tags to finish our HTML Wrapping.
            sb.append("</body></html>");

            /* Set the formated HTML text to the JLabel */
            label.setText(sb.toString());
        }
    }
    catch (IOException ex) {
        Logger.getLogger("displayFileInJLabel() Method").log(Level.SEVERE, null, ex);
    }
}