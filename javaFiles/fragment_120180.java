jssc.start();

    while (numberInst < 100){
        jssc.awaitTerminationOrTimeout(1000); // 1 second polling time, you can change it as per your usecase
    }

    jssc.stop();