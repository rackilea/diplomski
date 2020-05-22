<bean id="ftpClientFactory"
    class="org.springframework.integration.ftp.session.DefaultFtpSessionFactory">
    <property name="host" value="${host.name}" />
    <property name="port" value="${host.port}" />
    <property name="username" value="${host.username}" />
    <property name="password" value="${host.password}" />
    <property name="bufferSize" value="100000"/>
</bean>
<int:channel id="ftpChannel" />
<int-ftp:outbound-channel-adapter id="ftpOutbound"
    channel="ftpChannel" remote-directory="/yourremotedirectory/" session-factory="ftpClientFactory" use-temporary-file-name="false" />