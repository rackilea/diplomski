(inc Long/MAX_VALUE) ; java.lang.ArithmeticException

(unchecked-inc Long/MAX_VALUE) ; wraps.
-9223372036854775808

(def chessboard (atom 0))
@chessboard
;=> 0
(bit-test @chessboard 1)
;=> false
(swap! chessboard bit-flip 1)
;=> 2
(bit-test @chessboard 1)
;=> true
@chessboard
;=> 2
(reset! chessboard 0)
;=> 0
(swap! chessboard bit-flip 63)
;=> -9223372036854775808 
(bit-test @chessboard 63)
;=> true