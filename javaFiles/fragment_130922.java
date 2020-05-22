@Data
    public static class ResponseVo {
        private Object1 obj1;

        private Object2 obj2;

        public  static ResponseVo getInstance(Object1 obj1, Object2 obj2) {
            ResponseVo vo = new ResponseVo();
            vo.setObj1(obj1);
            vo.setObj2(obj2);
            return vo;
        }
    }

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
    public ResponseEntity<ResponseVo> test() {

        Object1 object1 = new Object1();
        object1.setObject1Integer(1);
        object1.setObject1String("obj1");

        Object2 object2 = new Object2();
        object2.setObject2String("obj2");
        object2.setObject2Integer(2);
        object2.setObject2Obj(object1);



        return new ResponseEntity<>(ResponseVo.getInstance(object1, object2), HttpStatus.OK);
    }