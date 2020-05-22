[INFO] ------------------------------------------------------------------------
[INFO] Building AspectJ sample with declare error 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- aspectj-maven-plugin:1.10:compile (default) @ aspectj-application-contract-enforcer ---
[INFO] Showing AJC message detail for messages of types: [error, warning, fail]
[ERROR] "Applications with main methods have to implement BasicInterface or extend ApplicationBase"
    C:\Users\alexa\Documents\java-src\SO_AJ_EnforceMainClassImplementingInterface\src\main\java\de\scrum_master\app\UnwantedApplication.java:12
public static void main(String[] args) {
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------