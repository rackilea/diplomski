public static String modify(String expression)
    {
        String temp = expression;
        StringBuilder validated = new StringBuilder();
        boolean inBrackets=false;

        for(int idx=0; idx<temp.length()-1; idx++)
        {
            if((Character.isLetter(temp.charAt(idx))) && (Character.isLetter(temp.charAt(idx+1))))
            {
                if(!inBrackets){
                    inBrackets = true;
                    validated.append("(");
                }
                validated.append(temp.substring(idx,idx+1));
                validated.append("*");
            }
            else{
                validated.append(temp.substring(idx,idx+1));
                if(inBrackets){
                    validated.append(")");
                    inBrackets=false;
                }
            }
        }
        validated.append(temp.substring(temp.length()-1));
        if(inBrackets){
            validated.append(")");
            inBrackets=false;
        }
        return validated.toString();
    }