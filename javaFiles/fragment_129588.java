java    
 enum Foo {...}
 enum Bar {...}

 // register the appropriate codecs
 CodecRegistry.DEFAULT_INSTANCE
     .register(new EnumOrdinalCodec<Foo>(Foo.class))
     .register(new EnumNameCodec<Bar>(Bar.class))

 // the following mappings are handled out-of-the-box
 @Table
 public class MyPojo {
     private Foo foo;
     private List<Bar> bars;
     ...
 }