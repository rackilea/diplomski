TypedBlock<IOException> foo = ...;

// do your work
final Validation<IOException, Unit> validation = Try.f(() -> {
  foo.run();
  return Unit.unit(); // Unit equals nothing in functional languages
})._1();

// check if we got a failure
if (validation.isFail()) {
  System.err.println("Got err " + validation.fail());
}

// check for success
if (validation.isSuccess()) {
  System.out.println("All was good :-)");
}

// this will just print out a message if we got no error
validation.forEach(unit -> System.out.println("All was good"));