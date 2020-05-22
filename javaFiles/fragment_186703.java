SomeObject<Long, String> =
    SomeObject.builder()
        .withType( new Integer(1) )
        .withList( Arrays.asList("abc","def") )
        .withType( new Long(1L) ) // <-- changing T here
        .create();