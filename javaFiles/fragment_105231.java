<target name="get build ctr">

    <script language="javascript">
        <![CDATA[

                // getting the value
                buildnumber = myproj.getProperty("build.number");
                index = buildnumber.lastIndexOf(".");
                counter = buildnumber.substring(index+1);
                myproj.setProperty("buildctr",counter);

            ]]>
    </script>

</target>