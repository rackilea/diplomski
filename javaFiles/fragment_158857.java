<int-file:inbound-channel-adapter 
        directory="${inputFileDirectory:/tmp}"
        channel="inputFiles"/>

<int:channel id="inputFiles">
    <int:dispatcher task-executor="executor"/>
</int:channel>

<int:splitter 
    input-channel="inputFiles" 
    output-channel="output">
    <bean 
        class="FileSplitter" 
        p:commentPrefix="${commentPrefix:#}" />
</int:splitter>

<task:executor 
    id="executor" 
    pool-size="${poolSize:8}" 
    queue-capacity="${aueueCapacity:0}" 
    rejection-policy="CALLER_RUNS" />

<int:channel id="output"/>