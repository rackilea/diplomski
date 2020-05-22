<copy todir="${web.dir}/WEB-INF/">
        <fileset dir="src/main/webapp/WEB-INF/">
            <include name="**/*.*" />
        </fileset>
        <filterchain>
            <striplinecomments>
                <comment value="!" />
            </striplinecomments>
            <replacetokens>
                <token key="hibernate.connection.url" value="${hibernate.connection.url}" />
                <token key="hibernate.connection.username" value="${hibernate.connection.username}" />
                <token key="hibernate.connection.password" value="${hibernate.connection.password}" />
                <token key="fontFamily" value="arial, helvetica, sans-serif" />
            </replacetokens>
        </filterchain>
    </copy>