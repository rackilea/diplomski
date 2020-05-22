// One type variable declared on the class, used by
// both maps.
//                           vvvvvvvvvvvvvvvvvvvvvvv
class MyTemplatedClass <..., T2A extends AnInterface, ...> 
    implements ... {

    @Override
    // Another different type variable declared
    // on the method.
    //     vvvvvvvvvvvvvvvvvvvvvvvv
    public <T2B extends AnInterface> void evaluatePopulationAndStoreResults(...) {
        {

            Tuple3<Integer, Individual<T2B>, Double> triplet =
                new Tuple3<>(iteration, element, fitness);

            //                              Passing a Map using T2A
            //                                   vvvvvvvvvvvvvvvvvv
            doSomeListOperationOnMapForAGivenKey(resultsByIteration,
                                                 new Integer(5),
            //           Passing a Tuple3<..., T2B, ...>
            //                                   vvvvvvv
                                                 triplet);
        }
    }