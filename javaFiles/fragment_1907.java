class BuildThreeObjects{
    int count = 0;
    public Object buildObject(){
        if(count >= 3){
            return null;
        } else {
            count++;
            return new Object();
        }
    }
}

private BuildThreeObjects bto;

@Before
public void setUp() throws Exception {
    bto = new BuildThreeObjects();
}

@Test
public void testBuild() {
    assertNotNull(bto.buildObject());
    System.out.println(bto.count);
    assertNotNull(bto.buildObject());
    System.out.println(bto.count);
    assertNotNull(bto.buildObject());
    System.out.println(bto.count);
    assertNull(bto.buildObject());
    System.out.println(bto.count);
}