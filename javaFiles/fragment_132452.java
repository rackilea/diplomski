String key= null;
        String value="somename";
        for(Map.Entry entry: MyType.entrySet()){
            if(value.equals(entry.getValue())){
                key = entry.getKey();
                break; //breaking because its one to one map
            }
        }