(ns your-namespace
  (:import [org.rapidoid.http Req ReqHandler]))

; Helper to create an object that implements ReqHandler
(defn makeReqHandler [f]
  ; Basically "new ReqHandler {...}"
  (reify ReqHandler
    (execute [this, ^Req req] (f req))