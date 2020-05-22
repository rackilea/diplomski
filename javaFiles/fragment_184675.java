public void testPlugins(){

    Processor plugin = (Processor) loadJars("C:\\Users\\...\\Desktop\\processor.jar",
            "C:\\Users\\...\\Desktop\\plugin.jar",
            "test.process.Process");
    processor.loadData("dada");

}