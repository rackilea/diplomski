(defproject kafka2hdfs "0.1.0-SNAPSHOT"
  :description "demo to show read from kafka and write to hdfs"
  :url "http://blog.csdn.net/csfreebird"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.apache.kafka/kafka_2.10 "0.8.2.1"
                  :exclusions [[org.apache.zookeeper/zookeeper]
                               [log4j/log4j]
                               [slf4j-api/org.slf4j]]
                  ]
                 [org.apache.storm/storm-kafka "0.9.5"]
                 [org.apache.storm/storm-hdfs "0.9.5"]]
  :main kafka2hdfs.core
  :aot [kafka2hdfs.core]
  :profiles {:provided {:dependencies [[org.apache.storm/storm-core "0.9.5"
                                        :exclusions [[org.slf4j/log4j-over-slf4j]
                                                     [org.slf4j/slf4j-api]
                                                     [logback-classic/ch.qos.logback]]
                                        ]]}}
  :plugins [[cider/cider-nrepl "0.10.0-SNAPSHOT"]]
  :target-path "target/%s")