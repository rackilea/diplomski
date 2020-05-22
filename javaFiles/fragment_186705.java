SomeObject<Long, String> =
    SomeObject.builder()
        .withType( new Integer(1) )
        .withList( Arrays.asList("abc","def") )
        .withType( new Long(1L) ) // <-- compiler error here
        .create();