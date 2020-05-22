user> 
(defn get-pixels [^java.awt.image.BufferedImage img [x y] [w h]] 
  (for [x (range x (+ x w))
        y (range y (+ y h))]
    (let [c (Color. (.getRGB img x y))]
      [(.getRed c) (.getGreen c) (.getBlue c)])))
#'user/get-pixels

user> (time (average-color (get-pixels image [0 0] [300 300])))
;;"Elapsed time: 149.073099 msecs"
[4822271/22500 3535699/18000 15749839/90000]