@Test
public void someTest() throws Exception {
    //Some code...
    stepLogic();
    //Some more assertions...
}

@Step("This is step 1")
private void step1Logic() {
    // Step1 implementation
} 

@Step("This is step 2")
private void step2Logic() {
    // Step2 implementation
}