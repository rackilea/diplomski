<datasource jndi-name="java:jboss/MySqlDS8" pool-name="MySqlDS8">
                <connection-url>jdbc:mysql://localhost:3306/mysql?useSSL=false&amp;useUnicode=yes&amp;characterEncoding=UTF-8&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC</connection-url>
                <driver>mysql8</driver>
                <security>
                    <user-name>root</user-name>
                    <password>12341234</password>
                </security>
                <validation>
                    <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker"/>
                    <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter"/>
                </validation>
            </datasource>