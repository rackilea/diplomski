String line, newLine = (String)System.getProperty("line.separator");
while((line = in.readLine()) != null){
//Will only work if the file is properly formatted
StringTokenizer st = new StringTokenizer(line, " ");
firstName = st.nextToken();
lastName = st.nextToken();
grade = st.nextToken();
gradeint = Integer.parseInt(grade);

gradeavg = gradeavg + gradeint;

count++;

                    if (gradeint <=69)
        {
            S69andbelow = S69andbelow + lastname + " " 
                    + firstname + " " + "\t" + grade + newLine;
        }   
        else if (gradeint >= 70 && gradeint <= 79)
        {
            S70to79 = S70to79 + lastname + " " + firstname 
                    + " " + "\t" + grade + "\n";
        }   

        else if (gradeint >= 80 && gradeint <=89)
        {
            S80to89 = S80to89 + lastname + " " + firstname 
                    + " " + "\t" + grade + newLine;
        }   

        else 
        {
            S90to100 = S90to100 + lastname + " " + firstname
                     + " " + "\t" + grade + newLine;
        }


}