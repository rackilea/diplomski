public String getPropertyString (){
            Properties prop = System.getProperties();

StringBuilder propertyString = new StringBuilder();
            Set<Object> keySet = prop.keySet();
            for(Object obj : keySet){
                propertyString.append("System Property: {"+obj.toString()+","+System.getProperty(obj.toString())+"}");
            }

return propertyString.toString();
}