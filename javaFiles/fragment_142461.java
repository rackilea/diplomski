(some.Example/-toString ...)

(use '[some.Example :only [-toString]])
(-toString ...)

(require '[some.Example :refer [-toString]])
(-toString ...)

(require '[some.Example :as se])
(se/-toString ...)

;; refer and alias are typically not used directly