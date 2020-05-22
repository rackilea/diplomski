user> (in-ns (symbol "1foo"))
#<Namespace 1foo>
1foo> (clojure.core/refer-clojure)
nil
1foo> (defrecord Foo [])
1foo.Foo
1foo> (in-ns 'user)
#<Namespace user>
user> (1foo.Foo.)
; Evaluation aborted.   ;; can't do that
user> (eval `(new ~(symbol "1foo.Foo")))
#:1foo.Foo{}