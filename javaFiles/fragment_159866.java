$ export GIRAPH_HOME=/share/apps/giraph
$ export HADOOP_CLASSPATH=/home/<me>/kdl_hadoop_play.jar:$GIRAPH_HOME/giraph-ex.jar:$HADOOP_CLASSPATH
$ export LIBJARS=/home/<me>/kdl_hadoop_play.jar,$GIRAPH_HOME/giraph-core.jar
$ hadoop fs -rm -R goutput/shortestpathsC2
$ hadoop jar $GIRAPH_HOME/giraph-ex.jar org.apache.giraph.GiraphRunner \
-Dgiraph.zkList=<myhost>:2181 \
-libjars ${LIBJARS} \
KdlSimpleShortestPathsVertex \
-vif org.apache.giraph.io.formats.JsonLongDoubleFloatDoubleVertexInputFormat \
-vip /user/cornell/ginput/tiny_graph.txt \
-of org.apache.giraph.io.formats.IdWithValueTextOutputFormat \
-op /user/cornell/goutput/shortestpathsC2 \
-ca SimpleShortestPathsVertex.source=2 \
-w 1
...
$ hadoop fs -cat goutput/shortestpathsC2/p*