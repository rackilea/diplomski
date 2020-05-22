public void orange(){}

@Test(dependsOnMethods = { "orange" })
public void apple(){}

@Test(dependsOnMethods = { "apple" })
public void mango(){}