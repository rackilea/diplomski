String[] arrSearch=searchString.split("\\s");
        StringBuffer sb = new StringBuffer();
        boolean skipFlag = false;
        for(int i=0;i<arrSearch.length;i++){
            System.out.println(arrSearch[i]);
            if(!skipFlag && arrSearch[i].startsWith("\"")){
                skipFlag = true;
                continue;
            }else if(skipFlag){
                if(arrSearch[i].endsWith("\"")){
                    skipFlag = false;
                    continue;
                }else{
                    continue;
                }
            }else if(arrSearch[i].startsWith("(")){
                String temp = arrSearch[i].substring(1);
                sb.append("(selenium.isTextPresent(" + temp + ")" + " ");
            }else if(arrSearch[i].startsWith(")")){
                String temp = arrSearch[i].substring(0,arrSearch[i].length()-1);
                sb.append("selenium.isTextPresent(" + temp + "))" + " ");
            }else if(arrSearch[i].equalsIgnoreCase("AND")){
                sb.append("&&" + " ");
            }else if(arrSearch[i].equalsIgnoreCase("OR")){
                sb.append("||" + " ");
            }else if(arrSearch[i].equalsIgnoreCase("NOT")){
                sb.append("!");
            }else if(arrSearch[i].endsWith("*")){
                String temp = arrSearch[i].substring(0,arrSearch[i].length()-1);
                sb.append("selenium.isTextPresent(\"//*[contains('" + temp + "')]\")" + " ");
            }else{
                sb.append("selenium.isTextPresent(" + arrSearch[i] + ")" + " ");
            }