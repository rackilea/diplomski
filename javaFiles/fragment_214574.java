(...)
[INFO] ------------------------------------------------------------------------
[INFO] Building AspectJ - fail build for wrong/missing annotations 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
(...)
[ERROR] singleton bean auto-wired into prototype container via constructor
    C:\Users\Alexander\Documents\java-src\SO_AJ_MavenFailBuildOnWrongAnnotation\src\main\java\de\scrum_master\app\BeanWithAutowire.java:14
public BeanWithAutowire(ScopedBean scopedBean) {
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

[ERROR] singleton bean auto-wired into prototype container via setter method
    C:\Users\Alexander\Documents\java-src\SO_AJ_MavenFailBuildOnWrongAnnotation\src\main\java\de\scrum_master\app\BeanWithAutowire.java:19
public void setScopedBean(ScopedBean scopedBean) {
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

[ERROR] Spring component without scope declaration found
    C:\Users\Alexander\Documents\java-src\SO_AJ_MavenFailBuildOnWrongAnnotation\src\main\java\de\scrum_master\app\UnscopedBean.java:6
public class UnscopedBean {}
             ^^^^^^^^^^^

[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
(...)