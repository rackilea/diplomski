int numberOfLine=0;

while((aLine=bufferedReader.readLine()) != null )
     {
            if(numberOfLine >= 1) //since header lies in first line,I want to skip that line
            {
             list.add(Integer.parseInt(aLine));
            }
             numberOfLine++;


     }