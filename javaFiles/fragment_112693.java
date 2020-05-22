//get Bar class
Class barClass = Class.forName("com.xyz.Foo$Bar");

//instantiate Builder through newBuilder method
Method newBuilderMethod = barClass.getMethod("newBuilder");
Bar.Builder builder = (Bar.Builder) newBuilderMethod.invoke(null);

// ... set properties  -- can be through reflection if necessary

//build:
Bar bar = builder.build();