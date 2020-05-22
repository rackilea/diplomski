(defn double-loop [i-count j-count]
  (loop [i 0]
    (loop [j 0]
      (if (= j j-count)
        j
        (do
          (.flush System/out)
          (recur (inc j)))))

    (if (= i i-count)
      i

      (recur (inc i)))))

(time (double-loop 1000 10000))  ; "Elapsed time: 1194.718969 msecs"