(let [ts [(java.util.ArrayList. 1)
          (java.util.ArrayList. 1)
          (java.util.ArrayList. 1)]]
  ; Use a lazy map, but realize sequence using doall
  (doall (map #(.add %1 %2) ts ["s1" "s2" "s3"]))
  (mapv #(.get %1 0) ts))