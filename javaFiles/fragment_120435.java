static {
    digester.setAlgorithm("SHA-256");
    digester.setIterations(100000);
    digester.setSaltSizeBytes(0);
    digester.initialize();
}