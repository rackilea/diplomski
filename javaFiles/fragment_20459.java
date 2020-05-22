<story path="org/irko/my_jbehave_simple/stories/my.story" title="">
    <scenario keyword="Scenario:" title="A scenario with some pending steps">
        <examples keyword="Examples:">
            <step>Given I am a pending step &lt;Step&gt;</step>
            <step>When a good soul will implement me</step>
            <step>Then I shall be happy &lt;Val&gt;</step>
            <parameters>
                <names>
                    <name>Step</name>
                    <name>Val</name>
                </names>
                <values>
                    <value>1</value>
                    <value>1</value>
                </values>
                <values>
                    <value>2</value>
                    <value>2</value>
                </values>
            </parameters>

            <example keyword="Example:">{Step=1, Val=1}</example>
            <step outcome="successful">
                Given I am a pending step
                <parameter>1</parameter>
            </step>
            <step outcome="successful">When a good soul will implement me</step>
            <step outcome="successful">
                Then I shall be happy
                <parameter>1</parameter>
            </step>

            <example keyword="Example:">{Step=2, Val=2}</example>
            <step outcome="successful">
                Given I am a pending step
                <parameter>2</parameter>
            </step>
            <step outcome="successful">When a good soul will implement me</step>
            <step outcome="successful">
                Then I shall be happy
                <parameter>2</parameter>
            </step>
        </examples>
    </scenario>
</story>