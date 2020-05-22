@Test
   public void mockSystemGetenvMethod()
   {
      new Expectations()
      {
         @Mocked("getenv") System mockedSystem;

         {
            System.getenv("envVar"); returns(".");
         }
      };

      assertEquals(".", System.getenv("envVar"));
   }