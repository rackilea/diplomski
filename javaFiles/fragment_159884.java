<authentication-manager>
    <authentication-provider>
        <jdbc-user-service data-source-ref="dataSource"

       users-by-username-query="
         SELECT USERNAME, PASSWORD, CASE ENABLED WHEN 1 THEN 'true' ELSE 'false' END 'ENABLED' 
         FROM TBL_USERS 
         WHERE USERNAME=?;"

       authorities-by-username-query="
        SELECT u.USERNAME, r.ROLENAME 
        FROM TBL_USERS u, TBL_USER_ROLE r
        WHERE u.ID = r.USERID
        AND u.USERNAME=?;"

        />
    </authentication-provider>
</authentication-manager>