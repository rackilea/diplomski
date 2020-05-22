(defn md5-with-charset
  [s charset]
  (let [algorithm (java.security.MessageDigest/getInstance "MD5")]
    (.digest algorithm (.getBytes s charset))))

(b64 (md5-with-charset "’" "UTF-8"))  ;; => "yOy9/y97p/GfapveLVQAHA=="
(b64 (md5-with-charset "’" "ASCII"))  ;; => "0UV7csP7MjomcRJa7z6rXQ=="
(b64 (md5-with-charset "’" "UTF-16")) ;; => "3CLVThylT2KkrocdUpxIpg=="
(b64 (md5-with-charset "’" "UTF-32")) ;; => "iHBMMMzkWTbPU+n8GCHitQ=="