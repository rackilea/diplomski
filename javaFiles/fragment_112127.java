(defn scan-for [tokens]
  (comp
    (partial remove empty?)
    flatten
    (partial map rest)
    (->> tokens
         (sort (comp not neg? compare)) ;alternatively, we can short by decreasing length
         (map #(java.util.regex.Pattern/quote %))
         (clojure.string/join \|)
         (#(str "((?s).*?)(" % "|\\z)"))
         (re-pattern)
         (partial re-seq))))