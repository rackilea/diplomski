<insert id="saveOrUpdate" parameterType="UserLearningCourse" useGeneratedKeys="true"
    keyProperty="id" keyColumn="id">
<selectKey keyProperty="count" resultType="int" order="BEFORE">
    SELECT COUNT(*) count FROM user_learning_course
    where user_identifier = #{userIdentifier}
            AND course_identifier = #{courseIdentifier}
</selectKey>

<if test="count > 0">
    UPDATE user_learning_course
    <set>
        <if test="courseIdentifier!=null">
            course_identifier = #{courseIdentifier},
        </if>
        <if test="bestCourseGrade!=null">
            best_grade = #{bestCourseGrade},
        </if>
        <if test="latestCourseGrade!=null">
            latest_grade = #{latestCourseGrade},
        </if>
        <if test="totalNumberOfSequences!=null">
            total_number_of_sequences = #{totalNumberOfSequences},
        </if>
        <if test="lastModifiedAt!=null">
            last_modified_at = #{lastModifiedAt},
        </if>
    </set>
    <where>
            user_identifier = #{userIdentifier}
            AND course_identifier = #{courseIdentifier}
    </where>
</if>
<if test="count==0">
    INSERT INTO `user_learning_course` (
    user_identifier,
    course_identifier,
    best_grade,
    latest_grade,
    total_number_of_sequences,
    last_modified_at
    )
    VALUES (
    #{userIdentifier},
    #{courseIdentifier},
    #{bestCourseGrade},
    #{latestCourseGrade},
    #{totalNumberOfSequences},
    #{lastModifiedAt}
    )
</if>