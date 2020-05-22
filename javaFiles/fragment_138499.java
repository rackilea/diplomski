void test(Object foo) {
  if (!(foo instanceof Number)) {
    if (foo instanceof Integer) { 
      // always false: "not instanceof Number" fact is not compatible 
      // with "instanceof Integer"
    }
  }
}