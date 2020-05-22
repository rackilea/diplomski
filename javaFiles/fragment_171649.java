aload_1 //load the names var

// call its stream() func
invokeinterface java/util/List.stream:()Ljava/util/stream/Stream;

//invokeDynamic magic!
invokedynamic #0:apply:()Ljava/util/function/Function;

//call the map() func
invokeinterface java/util/stream/Stream.map:
(Ljava/util/function/Function;)Ljava/util/stream/Stream;