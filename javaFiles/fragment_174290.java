<select id="selectCalendarType" parameterType="int" resultMap="calendarTypeMap">
    SELECT c.id,
    c.symbol
    t.roleId,
    t.permissionSymbol
    FROM CalendarType c
    LEFT JOIN TypePermission t ON c.id = t.c_id
    WHERE c.id = #{id}
</select>