(let [ts [(java.util.ArrayList. 1)
          (java.util.ArrayList. 1)
          (java.util.ArrayList. 1)]]
  ; Add one element to each of the ArrayList's
  (doall (map #(.add %1 %2) ts ["s1" "s2" "s3"]))

  ; Verify that elements are indeed added.
  (doall (map #(.get %1 0) ts)))