return async( 
  request                 
  .get()                   // returns a `Promise<Response>`
  .map(resultFromResponse) // map takes a `Function<Response, Result>` and
                           // returns the `Promise<Result>` we need
);