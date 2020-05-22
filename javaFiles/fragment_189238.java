@AfterEach 
void afterEach(TestInfo info) {
    if(!info.getTags().contains("cleanItUp")) return; // preconditioning only to needs clean up
        //// Clean up logic Here
}


@Test
@Tag("cleanItUp")
void myTest() {

}