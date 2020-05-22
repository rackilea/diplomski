<test name="Test">
    <method-selectors>
        <method-selector>
            <script language="beanshell">
                <![CDATA[
                    String myTestGroup = System.getProperty("chooseCase");
                    groups.containsKey(myTestGroup);
                ]]>
            </script>
        </method-selector>
    </method-selectors>

    <classes>
        <class name="AppTest"/>
        <class name="AppTest2"/>
    </classes>
</test>