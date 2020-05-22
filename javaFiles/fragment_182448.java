private enum HelperEnum {
       TYPE1(TypeAction.TYPE1),
       TYPE2(TypeAction.TYPE2),
       TYPE3(TypeAction.TYPE3),
       OTHERTYPE1(OtherTypeAction.OTHERTYPE1),
       OTHERTYPE2(OtherTypeAction.OTHERTYPE2),

       private Request<T extends Response> source;

       private HelperEnum(Request<T extends Response> source) {
           this.source = source;
       }

       private static Map<Request<T extends Response>, HelperEnum> map;

       public static HelperEnum lookUp(Request<SomeEnumClassThatImplementsResponse> source) {
           if (map == null) {
               map = Arrays.stream(HelperEnum.values())
                   .collect(Collectors.toMap(x -> x.source, x -> x));
           }
           return map.get(source);
       }