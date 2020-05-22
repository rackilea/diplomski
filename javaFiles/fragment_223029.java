(let [ts [(java.util.ArrayList. 1)
          (java.util.ArrayList. 1)
          (java.util.ArrayList. 1)]]
  ; Use a lazy map here - without doall
  (map #(.add %1 %2) ts ["s1" "s2" "s3"])
  (doall (map #(.get %1 0) ts)))

; java.lang.IndexOutOfBoundsException: Index: 0, Size: 0