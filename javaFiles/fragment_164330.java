;; Use ordinary Clojure functions to construct this
(def the-static-methods {:foo ["Integer" "parseInt"], :bar ["Long" "parseLong"]})

;; Macros have access to all previously defined values
(defmacro generate-defns []
  (cons `do (for [[name-keyword [class-string method-string]] the-static-methods]
              `(defn ~(symbol (name name-keyword)) [x#]
                 (. ~(symbol class-string) ~(symbol method-string) x#)))))

(generate-defns)