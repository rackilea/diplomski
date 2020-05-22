(defn ease-coord [factor src tgt]
  (+ src (* (- tgt src) factor)))

(defn ease [factor src tgt]
  (map (partial ease-coord factor) src tgt))

(ease 0.1 [1 2] [3 10])
;=> (1.2 2.8)
(ease 0.1 [1 2 3] [3 10 5])
;=> (1.2 2.8 3.2)