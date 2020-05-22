int arrSize = xmlCharValPairs.length()        
    String[] xmlCharValPairs = xmlTag.split("\"");
    StringBuilder sb = new StringBuilder(arrSize);

    sb.append("<" + xmlCharValPairs[0] + " ");

    for (int i = 1; i < arrSize-1; i++) {
        if (i%2 == 0) 
            sb.append("\"" + xmlCharValPairs[i].trim() + "\" ");
        else 
            sb.append(xmlCharValPairs[i]);
    }

    String returnXMLFormat = sb.toString();