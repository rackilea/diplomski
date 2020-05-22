cd D:\NB82\MavenChineseChars; JAVA_HOME=C:\\Java\\jdk1.8.0_181 M2_HOME=C:\\apache-maven-3.6.0 cmd /c "\"\"C:\\apache-maven-3.6.0\\bin\\mvn.cmd\" -Dexec.args=\"-classpath %classpath com.unthreading.mavenchinesechars.ChineseChars\" -Dexec.executable=C:\\Java\\jdk1.8.0_181\\bin\\java.exe -Dmaven.ext.class.path=C:\\NetBeans9\\java\\maven-nblib\\netbeans-eventspy.jar org.codehaus.mojo:exec-maven-plugin:1.5.0:exec\""
Running NetBeans Compile On Save execution. Phase execution is skipped and output directories of dependency projects (with Compile on Save turned on) will be used instead of their jar artifacts.
Scanning for projects...

-----------------< com.unthreading:MavenChineseChars >------------------
Building MavenChineseChars 1.0-SNAPSHOT
--------------------------------[ jar ]---------------------------------

--- exec-maven-plugin:1.5.0:exec (default-cli) @ MavenChineseChars ---
System.getProperty("file.encoding"): Cp1252
Charset.defaultCharset(): windows-1252
System.getProperty("java.version"): 1.8.0_181
???
你好！
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  1.021 s
Finished at: 2018-12-12T18:24:12-05:00
------------------------------------------------------------------------