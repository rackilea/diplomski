(ns my.namespace
  "a trivial library"
  (:require [something.else :as other])
  (:gen-class
    :name my.classname
    :methods [
      ;   metadata      mtd.name signature  returns
      #^{:static true} [excite   [String]   void]
    ]))