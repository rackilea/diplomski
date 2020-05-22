pageFactoryA.getSectionAPage().clickButtonB();
pageFactoryB.getSectionBPage.fillInCustomerField( customerName );
pageFactoryA.getSectionCPage.clickButton("Display customer report");
// the above operation should display a new page: Customer Report
// so we get a CustomerReportPage from the factory
int total = pageFactoryC.getCustomerReportPage().getTotal();
assertEquals( total, 2000 );
.....