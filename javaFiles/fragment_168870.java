(defmacro make-primitive-affine-function [t a b]
  (let [cast #(list (symbol (name t)) %)
        x (gensym "x")]
    `(fn [~x] (+ (* ~(cast a) ~(cast x)) ~(cast b)))))

((make-primitive-affine-function :int 31 47) 5)
; => 202