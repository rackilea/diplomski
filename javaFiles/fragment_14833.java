public void resourceConsumption() {
    for (int i = 0; i < agentCount; i++) {
        for (int j = 0; j < resourceCount; j++) {
            System.err.println("BEFORE: " + resourcesHeld[i][j]);
            resourcesHeld[i][j] = resourcesHeld[i][j] * 3 / 4;
            System.err.println("AFTER: " + resourcesHeld[i][j]);

        }
    }
}