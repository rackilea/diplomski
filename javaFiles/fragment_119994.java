public void createJSON(){
        File outFile = new File("d://test.json");
        if (outFile.exists()){
            outFile.delete();
        }
        IpadField fieldaA = new IpadField("fieldA", "test", "test", "test", "test");
        IpadField fieldaB = new IpadField("fieldB", "test", "test", "test", "test");
        Map<String, IpadField> addIpadMap = addIpad(null, fieldaA);
        addIpadMap = addIpad(addIpadMap, fieldaB);
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(outFile, addIpadMap);
    }

    public Map<String, IpadField> addIpad(Map<String, IpadField> map, IpadField ipadField) {
        if (map == null)
            map = new HashMap<String, IpadField>();
        map.put(ipadField.fieldname, ipadField);
        return map;
    }