public Mono myNonBlockingHttpCallWithMono(Object someData) {
    return Mono.create(sink -> {
            myAsyncHttpClient.execute(someData, (result, exception -> {
                if(exception != null) {
                    sink.error(exception);
                    return;
                }
                sink.success(result);
            })
    });
} 

public Mono myUpperLevelBusinessLogic() {
    var mono = myNonBlockingHttpCallWithMono();

    // ... some code

    if (something) {
       // oh we don't really need anything, let's just throw an exception

       return Mono.error(new RuntimeException());
    }

   return mono;
}