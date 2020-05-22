RedeemablePromise<String> promise = RedeemablePromise.empty();

promise.map(string ->
  // This would apply once the redeemable promise succeed
  ok(string + " World!")
);

// In another thread, you now may complete the RedeemablePromise.
promise.success("Hello");

// OR you can fail the promise
promise.failure(new Exception("Problem"));