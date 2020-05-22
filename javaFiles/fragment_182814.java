} else {    
        String str = "";        
        if(Character.isDigit(first.charAt(0))){
            int num = Character.getNumericValue(first.charAt(0));               
            for (int i = 0; i < num; i++) {
                str += first.charAt(i);
            }
        }else{
            for (int i = 0; i < first.length(); i++) {
                str += first.charAt(i);
            }
        }
        first = str;
    }