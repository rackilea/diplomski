@Pointcut("execution(* com.package.*ActualImplemetation.someMethod(..))"
// OR
// using BaseInterface reference directly, you can use all sub-interface/sub-class methods
//@Pointcut("execution(* com.package.BaseInterface.someMethod(..))"
logMethod() { //ignore method syntax
 //.....
}