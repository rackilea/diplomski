<rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
     <fileNamePattern>${LOG_ARCHIVE}/rollingfile.log%d{yyyy-MM-dd}.log
     </fileNamePattern>
     <maxFileSize>10MB<maxFileSize>
     <maxHistory>30</maxHistory>
 </rollingPolicy>