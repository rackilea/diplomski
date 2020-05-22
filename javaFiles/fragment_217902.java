query = query.replaceAll("[^\\p{L}\\s0-9-_/.@]", "");
query = query.replaceAll("\t", " ");
query = query.replaceAll("\r", " ");
query = query.replaceAll("\n", " ");
StringTokenizer words = new StringTokenizer(query, " ");    
while(tokens.hasMoreTokens()){
        String str=tokens.nextToken();
        str = str.replaceAll("\\.\\B" , " "); *<-new line*
        String regex = "\\d+.\\d+";
        if(!str.matches(regex)) *<- second problem*
           System.out.println(str);