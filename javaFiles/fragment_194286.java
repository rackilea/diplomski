(every? (partial instance? java.io.Serializable)
        [{1 2} #{"asdf"} :foo 'foo (fn [] :foo)])
; => true

(defrecord Foo [])
(instance? java.io.Serializable (Foo.))
; => true