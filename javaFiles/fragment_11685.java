@Test
 public void testEqual(){
     int[]a={1,2,3,4,5,6,7};
     int[]b={7,6,5,4,3,2,1};
     Assert.assertEquals(a,b);
     Assert.assertTrue(Main.equalsHelper2(a,b,0,6));
}


@Test
 public void testDifferent(){
     int[]a={1,1,1,1,1,1,1};
     int[]b={7,6,5,4,3,2,1};
     Assert.assertNotEquals(a,b);
     Assert.assertFalse(Main.equalsHelper2(a,b,0,6));
}