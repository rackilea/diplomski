class TestSomePartOfApplication{
    KKKPages kkkPages = KKKPages.getInstance();
    AtosPages atosPages = AtosPages.getInstance();
    .....
    void testScenario1(){
       kkkPages.getPageA.fillField("Field name 1", 120 );
       kkkPages.getPageA.clickButtonOK();
       ......
    }

    void testScenario2(){
       kkkPages.getPageB.fillField("Field 15", "abc" );
       kkkPages.getPageA.clickButtonOK();
       atosPages.getPageC.fillField("Field 33", "Client name");
       ......
    }
}