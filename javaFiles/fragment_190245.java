private boolean checkEmptyVal(String key){

        boolean result = false;
        List<String> val = resultTable.get(key);

        if(val != null && val.contains("")) {
            result = true;              
        }

        return result;
    }