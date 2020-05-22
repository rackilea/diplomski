user> (defn foo [^Integer x] (+ 3 x))
#'user/foo
user> (.equals (foo 2) (foo 2))
Reflection warning, NO_SOURCE_FILE:1 - call to equals can't be resolved.  ;'
true
user> (.equals ^Integer (foo 2) ^Integer (foo 2))
true
user> (defn ^Integer foo [^Integer x] (+ 3 x))
#'user/foo
user> (.equals (foo 2) (foo 2))
true