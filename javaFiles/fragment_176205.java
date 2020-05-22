(ns riak.core
  (:import [com.basho.riak.client IRiakClient RiakFactory RiakException]
           [com.basho.riak.client.http.response RiakIORuntimeException]))

(set! *warn-on-reflection* true)
;; (def client (RiakFactory/pbcClient))
(def client (RiakFactory/httpClient))

(defn alive?
  "Is Riak client alive? Returns true or false, unlike `.ping`."
  [^IRiakClient client]
  (try
    (.ping client)
    true
    (catch RiakException e false)
    (catch RiakIORuntimeException e false)))