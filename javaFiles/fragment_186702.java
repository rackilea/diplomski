NeitherDoneStep step = SomeObject.builder();
BothDoneStep<String, Integer> both =
    step.withTyped("abc")
        .withList(Arrays.asList(123));
// setting 'typed' to an Integer when
// we already set it to a String
step.withTyped(123);
SomeObject<String, Integer> oops = both.create();