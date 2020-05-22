public static void initializeWeights() {
    for(int z = 0; z < arrayLUT.length; z++) { 
        // Initialize weights from input layer to hidden layer
        double rndWgtIH = Math.random() - 0.5;
        for (int i = 0; i < NUM_INPUTS; i++) {
            for (int j = 0; j < NUM_HIDDENS; j++) {
                wgtIH[z][i][j] = rndWgtIH;    
                dltWgtIH[i][j] = 0;
            }
        }
        // Initialize weights from hidden layer to output layer
        double rndWgtHO = Math.random() - 0.5;
        for (int j = 0; j < NUM_HIDDENS; j++) {
            for (int k = 0; k < NUM_OUTPUTS; k++) {
                wgtHO[z][j][k] = rndWgtHO;
                dltWgtHO[j][k] = 0;
            }
        }
    }
}