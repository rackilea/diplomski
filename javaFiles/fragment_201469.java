$ mvn exec:java -Dexec.mainClass="testing.App"
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building testing 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] >>> exec-maven-plugin:1.2.1:java (default-cli) @ testing >>>
[INFO]
[INFO] <<< exec-maven-plugin:1.2.1:java (default-cli) @ testing <<<
[INFO]
[INFO] --- exec-maven-plugin:1.2.1:java (default-cli) @ testing ---
JSONArray length => 2
details => {"sex":"M","Address":{"Home":"Home","Office":"office"},"age":"30","name":"xyz"}
xyz
30
details => {"sex":"M","Address":{"Home":"Home","Office":"office"},"age":3027,"name":"eryje"}
eryje
3027
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 0.576s
[INFO] Finished at: Fri Jul 17 10:46:29 JST 2015
[INFO] Final Memory: 7M/106M
[INFO] ------------------------------------------------------------------------