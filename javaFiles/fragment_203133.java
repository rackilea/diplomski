;; assuming that state-o-matic is an Atom which holds a map,
;; which holds the key of :foo, with which a vector is associated,
;; whose first item is another vector, whose first item is a map
;; which holds the key of :bar associated to a number,
;; the following increments said number
(swap! state-o-matic update-in [:foo 0 1 :bar] inc)