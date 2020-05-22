<package name="person" namespace="/person" extends="website">
    <action name="*/*" method="getPerson" class="PersonActionBean">
            <param name="param1">{1}</param>
            <param name="param2">{2}</param>
            <result>/person/view.jsp</result>
    </action>   
</package>