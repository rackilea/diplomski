public static void compute(ComputationMethod method){
    for(ComputationThread t:threads){
        t.computation = method;
        t.start();
    }

    // wait for all threads to finish
    for(ComputationThread t:threads){
        t.join();
    }
}