@Data
    public static class Object1{
        private String object1String;

        private Integer object1Integer;
    }

    @Data
    public static class Object2 {
        private String object2String;

        private Integer object2Integer;

        private Object1 object2Obj;
    }

    @GetMapping(value = "/test")
    public ResponseEntity<Map> test() {

        Object1 object1 = new Object1();
        object1.setObject1Integer(1);
        object1.setObject1String("obj1");

        Object2 object2 = new Object2();
        object2.setObject2String("obj2");
        object2.setObject2Integer(2);
        object2.setObject2Obj(object1);

        ObjectMapper mapper = new ObjectMapper();
        Map map = mapper.convertValue(object1, Map.class);
        map.putAll(mapper.convertValue(object2, Map.class));

        return new ResponseEntity<>(map, HttpStatus.OK);
    }