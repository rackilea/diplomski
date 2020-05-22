<action name='start-job'>
    <java>
        <job-tracker>${jobTracker}</job-tracker>
        <name-node>${nameNode}</name-node>
        <configuration>
            <property>
                <name>mapred.job.queue.name</name>
                <value>${jobQueue}</value>
            </property>
        </configuration>
        <main-class>MyDriverClass</main-class>

        <arg>${arguments}</arg>
        <arg>${queueName}</arg>
        <arg>${wf:id()}</arg>
    </java>
    <ok to="end" />
    <error to="kill" />
</action>