<preGoal name="java:compile">
    <ant:path id="tools">
        <ant:pathelement path="${tools.jar}"/>
    </ant:path>
    <maven:addPath id="maven.dependency.classpath" refid="tools"/>
</preGoal>