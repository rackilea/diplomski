(defproject proguard "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]]
  :main proguard.core
  ;;; Make sure everything is aot compiled
  :aot :all
  ;;; Remove source .clj files from the resulting jar
  :omit-source true
  )