(binding [*print-dup* true] (println [1 2 3]))
; prints [1 2 3]

(defrecord Foo [x])
; => user.Foo
(binding [*print-dup* true] (println (Foo. :foo)))
; prints #=(user.Foo/create {:x :foo})