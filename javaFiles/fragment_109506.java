<t:selectOneRadio id="frequency" value="#{bean.frequency}" layout="spread">
    <f:selectItem itemLabel="Every" itemValue="Every" />
    <f:selectItem itemLabel="Every weekday" itemValue="Every weekday" />
</t:selectOneRadio>

<t:radio for="frequency" index="0" /><h:inputText value="#{bean.days}" /> days
<br />
<t:radio for="frequency" index="1" />