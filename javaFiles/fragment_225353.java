:methods [#^{:static true} [binomial [int int] clojure.lang.BigInt]]))
(defn binomial
  "Calculate the binomial coefficient."
  [n k]
  (let [a (inc n)]
    (loop [b 1
           c 1]
      (if (> b k)
        (bigint c) ;; <-- Without this code 
                   ;; java.lang.ClassCastException: 
                   ;; java.lang.Long cannot be cast to clojure.lang.BigInt occurs
        (recur (inc b) (* (/ (- a b) b) c))))))