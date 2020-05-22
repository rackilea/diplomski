<feature name='odl-odlmq' version='${project.version}' description='OpenDaylight :: odlmq'>
<feature version='${mdsal.version}'>odl-mdsal-broker</feature>
<feature version='${project.version}'>odl-odlmq-api</feature>
<bundle>mvn:org.opendaylight.odlmq/odlmq-impl/${project.version}</bundle>
<bundle dependency="true">mvn:org.apache.geronimo.specs/geronimo-jms_1.1_spec/1.1.1</bundle>
<bundle dependency="true">mvn:org.apache.geronimo.specs/geronimo-jta_1.1_spec/1.1.1</bundle>
</feature>