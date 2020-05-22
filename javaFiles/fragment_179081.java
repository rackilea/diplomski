class MyTemplatedClass <..., T2 extends AnInterface, ...> 
    implements ... {

    @Override
    // Declares a new type variable T2, unrelated to the
    // T2 declared on the class and shadows it.
    //     vvvvvvvvvvvvvvvvvvvvvvvv
    public <T2 extends AnInterface> void evaluatePopulationAndStoreResults(...) {
        {

            Tuple3<Integer, Individual<T2>, Double> triplet =
                new Tuple3<>(iteration, element, fitness);

            doSomeListOperationOnMapForAGivenKey(resultsByIteration,
                                                 new Integer(5),
                                                 triplet);
        }
    }