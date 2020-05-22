// same error on this line
// C (String) is not inferred
m(new ArrayList<List<String>>());

// the compiler is able to infer B from A
// but not C from A
static <A extends List<B>, B extends List<C>, C> void m(A a) {}