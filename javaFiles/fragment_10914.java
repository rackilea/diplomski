<mapper namespace="foo">

  <select id="selectWithRoles" parameterType="String" resultMap="personWithRoles">
    select * 
    from 
    PERSON P
    left outer join PERSON_ROLE R on P.ID = R.PERSON_ID
    where P.ID = #{id}
  </select>  

  <resultMap id="personWithRoles" type="Person">
    <id property="id" column="ID" />
    <collection property="roles" ofType="Role">
      <id property="personId" column="PERSON_ID"/>
      <result property="name" column="NAME"/>
    </collection>
  </resultMap>

</mapper>