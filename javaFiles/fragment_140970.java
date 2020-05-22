...
    String[] tokens = str.trim().split(" ");
    weights = new ArrayList<Double[][]>();
    int begin = 0;
    while(begin < tokens.length){
        int layerId = Integer.parseInt(tokens[begin]), neuronsAmt = Integer.parseInt(tokens[begin+1]), inputSize = Integer.parseInt(tokens[begin+2]);
        begin += 3;
        Double[][] wl = new Double[inputSize][neuronsAmt];
        Log.d("UpdateTask",  "Layer " + layerId + ", neuronios: " + neuronsAmt + ", inputSize: " + inputSize);
        for(int i = 0; i < inputSize; i++){ 
            for(int j = 0; j < neuronsAmt; j++){
                wl[i][j] = Double.valueOf(tokens[begin+i*neuronsAmt+j]);
            }
        }
        begin += inputSize*neuronsAmt;
        weights.add(wl);
    }
    ...