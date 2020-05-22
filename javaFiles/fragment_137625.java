while ((text = reader.readLine()) != null) { 
        StringTokenizer troops = new StringTokenizer(text,"="); 
        if(troops.countTokens() == 2){
            String list = troops.nextToken(); 
            String value = troops.nextToken(); 
            ....
        }else { 
            //ignore this line
        }
}