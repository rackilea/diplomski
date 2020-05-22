<select parameterType="Long" resultMap="UniversityResultMap">
    SELECT U.uni_id, U.uni_name, S.name_ofStudent, S.gpa, S.age, S.major, S.stu_id, S.stu_uni_id
    FROM UNIVERSITY U
    JOIN STUDENT S ON U.ID = S.UNIVERSITYID
    WHERE U.ID = #{id}
</select>