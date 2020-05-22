public void TestClass {

     @Test
     public void testClickButtonAndInteractWithTextbox(){
         // Initiate the page object
         Pageobject po = new PageObject();
         po.clickButtonAndWaitForTextbox();
         po.interactWithTextbox("blabla");
         // edit 27.04.14
         assertSomethingGoodHappened();
     }
}