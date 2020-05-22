(defn map-difference [m1 m2]
        (loop [m (transient {})
               ks (concat (keys m1) (keys m2))]
          (if-let [k (first ks)]
            (let [e1 (find m1 k)
                  e2 (find m2 k)]
              (cond (and e1 e2 (not= (e1 1) (e2 1))) (recur (assoc! m k (e1 1)) (next ks))
                    (not e1) (recur (assoc! m k (e2 1)) (next ks))
                    (not e2) (recur (assoc! m k (e1 1)) (next ks))
                    :else    (recur m (next ks))))
            (persistent! m))))