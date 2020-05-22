<choice>
            <when><simple>${header.x} == '1' && ${header.y} == '2'</simple>
                <log message="do something with message"/>
            </when>
            <otherwise>
                <log message="do something else"/>
            </otherwise>
</choice>