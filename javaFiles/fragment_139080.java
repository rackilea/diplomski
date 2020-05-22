@POST
public void add(@Suspended AysncResponse response, String body) {
    Calculator.getInstance().requestComputation(
            client, 
            Calculator.SupportedOperations.ADDITION,
            a,b,
            response);

    // you don't need to return anything from the resource method
    // calling `response.resume(someResponse)` (from inside the task)
    // is enough. That is why this method just returns `void`
}