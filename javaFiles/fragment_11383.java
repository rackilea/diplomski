@Test
public int foo(){
   Bar actualBar = foo.doThat(...);
   //...
   return intValue;
}

@Test
public void fooWithComputedInt(){
   Bar actualBar = foo.doThat(foo());
   //...
}