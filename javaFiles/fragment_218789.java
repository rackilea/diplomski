//Load the namespace 
    RT.var("clojure.core","eval").invoke(RT.var("clojure.core","read-string").invoke("(use 'test.clojure.core)"));

//Find a function in namespace
    IFn fn = (IFn)RT.var("test.clojure.core","hello");

//Call that function
    fn.invoke();