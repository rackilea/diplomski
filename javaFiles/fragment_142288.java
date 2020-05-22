for(String sValue : sourceValue){
        for(String tValue : targetValue){
            if(sValue.length() > 4 && tValue.length() > 4){
                String sKey = sValue.substring(1,5);
                String tKey = tValue.substring(1,5);
                if(sKey.equals(tKey)){
                    //Do your logic...
                }
            }
        }
    }