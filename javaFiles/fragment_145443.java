VectorAlgebra va = new VectorAlgebra();
    FlatNetwork flat = network.getFlat();
    do {
        train.iteration();
        va.clampComponents(flat.getWeights(), 5);
        System.out.println("Epoch #" + epoch + " Error:" + train.getError());
        epoch++;
    } while(train.getError() > 0.01);