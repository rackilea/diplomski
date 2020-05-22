<bean id="basicAwsCredentials" class="com.amazonaws.auth.BasicAWSCredentials">
    <constructor-arg name="accessKey" value="${s3.key}"/>
    <constructor-arg name="secretKey" value="${s3.secret}"/>
</bean>

<bean id="amazonS3Client" class="com.amazonaws.services.s3.AmazonS3Client">
    <constructor-arg name="awsCredentials" ref="basicAwsCredentials"/>
</bean>