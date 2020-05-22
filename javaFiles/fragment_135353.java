user> (set! *warn-on-reflection* true)
true

user> 
(defn get-pixels [img [x y] [w h]] 
  (for [x (range x (+ x w))
        y (range y (+ y h))]
    (let [c (Color. (.getRGB img x y))]
      [(.getRed c) (.getGreen c) (.getBlue c)])))

;;Reflection warning, *cider-repl localhost*:2136:21 - call to method getRGB can't be resolved (target class is unknown).
;;Reflection warning, *cider-repl localhost*:2136:21 - call to method getRGB can't be resolved (target class is unknown).
#'user/get-pixels

user> (time (average-color (get-pixels image [0 0] [300 300])))
;;"Elapsed time: 505.637246 msecs"
[4822271/22500 3535699/18000 15749839/90000]