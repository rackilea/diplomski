@Inject @Any
private Instance<Integer> integerInstance;


...

integerInstance.select(new MaxPassengersLiteral("foo")).get();