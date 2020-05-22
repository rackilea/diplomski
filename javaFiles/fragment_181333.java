<bean id="inboundDefaultSftpSessionFactory" class="org.springframework.integration.sftp.session.DefaultSftpSessionFactory">
    <property name="host" value="${sftp.host}" />
    <property name="privateKey" value="file:/home/tech/id_rsa"/>
    <property name="privateKeyPassphrase" value="${sftp.private.key.passphrase}"/>
    <property name="port" value="${sftp.port}" />       
    <property name="user" value="${sftp.user}" /> 
    <property name="password" value="${sftp.password}" />
</bean>