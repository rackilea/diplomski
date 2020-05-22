<root-logger>
      <level name="${jboss.server.log.threshold:INFO}"/>
      <handlers>
         <handler-ref name="CONSOLE"/>
         <handler-ref name="ERROR"/>
         <handler-ref name="FILE"/>
      </handlers>
   </root-logger>