$ cat TestClass.java
public interface TestInterface {
    void method();
}

$ cat TestConfig.xml
<?xml version="1.0"?>
<!DOCTYPE module PUBLIC
          "-//Puppy Crawl//DTD Check Configuration 1.3//EN"
          "https://checkstyle.org/dtds/configuration_1_3.dtd">

<module name="Checker">
    <property name="charset" value="UTF-8"/>

    <module name="TreeWalker">
<module name="JavadocMethod">
    <property name="scope" value="public"/>
    <property name="allowMissingParamTags" value="true"/>
    <property name="allowMissingThrowsTags" value="true"/>
    <property name="allowMissingReturnTag" value="true"/>
    <property name="allowedAnnotations" value="Override, Test"/>
    <property name="allowThrowsTagsForSubclasses" value="true"/>
</module>
    </module>
</module>

$ java -jar checkstyle-8.18-all.jar -c TestConfig.xml TestClass.java
Starting audit...
[ERROR] TestClass.java:2:5: Missing a Javadoc comment. [JavadocMethod]
Audit done.
Checkstyle ends with 1 errors.