(ns feeds.rss20-parser
  (:import (com.rometools.rome.io.impl RSS20Parser)
           (org.jdom2 Document))
  (:gen-class
   :name feeds.RSS20Parser
   :extends com.rometools.rome.io.impl.RSS20Parser
   :exposes-methods {isMyType parentIsMyType}))

(defn version [^Document doc]
  (some-> doc
          .getRootElement
          (.getAttribute "version")
          .getValue
          .trim))

(defn -isMyType [^feeds.RSS20Parser this ^Document doc]
  (or (.parentIsMyType this doc)
      (= "2" (version doc))))