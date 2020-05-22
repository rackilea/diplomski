public Tensor prepareData(){
    Random r = new Random();
    float[]inputArr = new float[NUMBER_OF_KEWORDS*NUMBER_OF_FIELDS];
    for (int i=0;i<NUMBER_OF_KEWORDS * NUMBER_OF_FIELDS;i++){
        inputArr[i] = r.nextFloat();
    }

    FloatBuffer inputBuff = FloatBuffer.wrap(inputArr, 0, NUMBER_OF_KEWORDS*NUMBER_OF_FIELDS);
    return Tensor.create(new long[]{NUMBER_OF_KEWORDS,NUMBER_OF_FIELDS}, inputBuff);
}

public void predict (Tensor inputTensor){
    try ( Session s = savedModelBundle.session()) {
        Tensor result;
        long globalStart = System.nanoTime();
            result = s.runner().feed("dense_1_input", inputTensor).fetch("dense_4/BiasAdd").run().get(0);

            final long[] rshape = result.shape();
            if (result.numDimensions() != 2 || rshape[0] <= NUMBER_OF_KEWORDS) {
                throw new RuntimeException(
                        String.format(
                                "Expected model to produce a [N,1] shaped tensor where N is the number of labels, instead it produced one with shape %s",
                                Arrays.toString(rshape)));
            }


        float[][] resultArray = (float[][]) result.copyTo(new float[NUMBER_OF_KEWORDS][1]);
        System.out.println(String.format("Total of %d,  took : %.4f ms", NUMBER_OF_KEWORDS, ((double) System.nanoTime() - globalStart) / 1000000));
        for (int i=0;i<10;i++){
            System.out.println(resultArray[i][0]);
        }
    }
}