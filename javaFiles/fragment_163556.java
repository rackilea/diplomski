<select id="searchSomeOne" parameterType="map" .....>
        SELECT
        ${pName} AS module
        FROM MY_TABLE
        WHERE
        COL_ONE = #{moduleName} and
        COL_TWO like #{username}
</select>