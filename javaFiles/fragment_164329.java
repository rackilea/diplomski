;; Here, the method name needs to be a *string literal*
(defmacro static-call
  "Takes a Class object, a string naming a static method of it
  and invokes the static method with the name on the class with
  args as the arguments."
  [class method & args]
  `(. ~class ~(symbol method) ~@args))