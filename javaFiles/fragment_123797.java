Map<String, Void> map = new HashMap<String,Void>();

    Constructor<Void> constructor= (Constructor<Void>) Void.class.getDeclaredConstructors()[0];
    constructor.setAccessible(true);
    Void voidObj = constructor.newInstance();

    map.put( "a", voidObj );
    map.put( "a", voidObj );
    assert map.size() == 1;