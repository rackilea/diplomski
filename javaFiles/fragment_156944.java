String fooValue = rb.getString("foo");
    String[] firstSplit = fooValue.split(";");
    for(String first : firstSplit){
        String firstTrim = first.trim();

        String[] intAndString = firstTrim.split(",");
        if(intAndString.length == 2){
            String intString = intAndString[0].trim();
            String stringVal = intAndString[1].trim();

            //TODO add entries here or return value.

        }
    }