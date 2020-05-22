Location:
org/apache/spark/sql/hive/orc/DefaultSource.createRelation(Lorg/apache/spark/sql/SQLContext;[Ljava/lang/String;Lscala/Option;Lscala/Option;Lscala/collection/immutable/Map;)Lorg/apache/spark/sql/sources/HadoopFsRelation; @35: areturn
Reason:
Type 'org/apache/spark/sql/hive/orc/OrcRelation' (current frame, stack[0]) is not assignable to 'org/apache/spark/sql/sources/HadoopFsRelation' (from method signature)
Current Frame:
bci: @35
flags: { }
locals: { 'org/apache/spark/sql/hive/orc/DefaultSource', 'org/apache/spark/sql/SQLContext', '[Ljava/lang/String;', 'scala/Option', 'scala/Option', 'scala/collection/immutable/Map' }
stack: { 'org/apache/spark/sql/hive/orc/OrcRelation' }