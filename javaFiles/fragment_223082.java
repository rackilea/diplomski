int attributeCount = xpp.getAttributeCount();
        for(int i = 0; i<attributeCount; i++){
            String name = xpp.getAttributeName(i);
            //Log.d(TAG, "Name: "+name);
            if(name != null && name.equalsIgnoreCase("column")){

                return Integer.parseInt(xpp.getAttributeValue(i));                
            }
        }