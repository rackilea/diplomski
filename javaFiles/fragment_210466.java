(macroexpand-1
 '(let [[a b] arr]
    (+ a b)))
;;=> (let* [vec__1 arr
;;          a (clojure.core/nth vec__1 0 nil)
;;          b (clojure.core/nth vec__1 1 nil)]
;;     (+ a b))

(macroexpand-1
 '(let [{a 0 b 1} arr]
    (+ a b)))
;;=> (let* [map__1 arr
;;          map__1 (if (clojure.core/seq? map__1)
;;                   (clojure.lang.PersistentHashMap/create
;;                    (clojure.core/seq map__1))
;;                   map__1)
;;          a (clojure.core/get map__1 0)
;;          b (clojure.core/get map__1 1)]
;;     (+ a b))