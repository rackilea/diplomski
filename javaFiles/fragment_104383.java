<rich:calendar id="scheduledDateStart" 
            value="#{Scheduled.scheduledDateStart}"
    popup="true" 
            enableManualInput="#{true}"
            scrollMode="client"                             
           timeZone="#{timeZone.timeZone}"
   datePattern="MM,dd,yyyy"                             
 >                   
 <f:convertDateTime type="date" pattern="MMMM dd, yyyy"  timeZone="#{timeZone.timeZone}"/>
</rich:calendar>