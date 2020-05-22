void original(List<Number> list) { /* ... */ }
void withUpperWildcard(List<? extends Number> list) { /* ... */ }
void withLowerWildcard(List<? super Number> list) { /* ... */ }

original(new ArrayList<Number>());       // OK.
original(new ArrayList<Integer>());      // Compiler-error.
original(new ArrayList<Object>());      // Compiler-error.

withUpperWildcard(new ArrayList<Number>());  // OK.
withUpperWildcard(new ArrayList<Integer>());  // OK.

withLowerWildcard(new ArrayList<Number>());  // OK.
withLowerWildcard(new ArrayList<Object>());  // OK.