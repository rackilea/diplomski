(require '[clojure.walk :as walk])

(defn compile-spec [spec]
  (let [params (atom #{})]
    (walk/prewalk
     (fn [item]
       (if (and (symbol? item) (.startsWith (name item) "param"))
         (do (swap! params conj item)
             item)
         item))
     spec)
    (eval `(fn [~@(sort @params)] ~@spec))))

(def my-spec '[(+ (* 31 param0) 47)])

((compile-spec my-spec) 5)
; => 202