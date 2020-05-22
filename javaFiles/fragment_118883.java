private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
        //creating a new lambda and return.
        // return (v,k) -> System.out.println(v+k); this would replace the lambda with addition lambda (v+k)

        return (v, k) ->  {
            try {
                consumer.accept(v, k); //execute whatever is passed in. 
            }
            catch (ArithmeticException e) {
                System.out.println("Exception caught in wrapper lambda");
            }

        };
}