int lineCount = 0;
int wordCount = 0;
String line = null;
        while((line = br.readLine()) != null){
            String[] word = line.split("\\s+");
            for(String segment : word)
            {
                holder[lineCount][wordCount++] = segment;                    
            }
            lineCount++;
            wordCount = 0; //I think now it should work, before I forgot to reset the count.
        }