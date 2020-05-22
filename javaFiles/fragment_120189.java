// Java
ByteBuffer buf = ByteBuffer.allocateDirect(16);
buf.order(ByteOrder.nativeOrder);

;; Clojure
(def buf (doto (ByteBuffer/allocateDirect 16)
           (.order (ByteOrder/nativeOrder)))