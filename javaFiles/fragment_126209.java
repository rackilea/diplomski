<changeSet author="kbatra" id="1.2">
        <createTable schemaName="public" tableName="${USER_TABLE_NAME}">
            <column name="id" autoIncrement="true" type="BIGINT">
                <constraints primaryKey="true" />
            </column>
            <column name="first_name" type="varchar(255)" />
            <column name="last_name" type="varchar(255)" />
            <column name="username" type="varchar(255)">
                <constraints unique="true" />
            </column>
            <column name="password" type="varchar(1000)" />
            <column name="email" type="varchar(255)" />
        </createTable>
    </changeSet>