void test(Object foo) {
  if (foo instanceof String) {
    if (foo instanceof Integer) { 
      // always false: "instanceof String" fact is not compatible 
      // with "instanceof Integer"
    }
  }
}