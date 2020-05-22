static String getQuery(String ... userInput){
        StringBuilder sb=new StringBuilder("SELECT * FROM mytable");
        if (userInput.length>0){
            sb.append(" where");
            for (int i=0;i<userInput.length;i++){
                sb.append(" column1 LIKE '%"+userInput[i]+"%'");
                if (i!=userInput.length-1) sb.append(" AND");
            }
        }
        sb.append(";");
        return sb.toString();
    }