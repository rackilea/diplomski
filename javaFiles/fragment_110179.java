@Test
public void correctAddition(){
        assertEquals(3, Main.plus(1,2));
}

@Test
public void wrongAddition(){
        //test will fail
        assertEquals(4, Main.plus(1,2));
}

@Test
public void wrongAddition2(){
        //test will also fail
        assertEquals(4, Main.plus(1,2));
}