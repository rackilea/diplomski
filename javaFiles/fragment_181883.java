;; create a HashSet
(def a (java.util.HashSet.))
(dotimes [i 10] (.add a i))

;; Get all the values as a sequence 
(seq a)
=> (0 1 2 3 4 5 6 7 8 9)

;; build a new HashSet containing the values from a 
(into #{} a)
#{0 1 2 3 4 5 6 7 8 9}

;; Just use the HashSet directly (high performance, no copy required)
(.contains a 1)
=> true
(.contains a 100)
=> false