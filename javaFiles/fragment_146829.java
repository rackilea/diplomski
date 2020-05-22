<select id="getQuestions" resultMap="Question">
    SELECT
        q.field_id,
        q.data_type,
        q.title,
        q.description,
        q.options
    FROM
        questions q
    WHERE
        job_id = #{job_id}
    AND
        field_id
    IN
        (SELECT 
            fs.field_id
        FROM
            question_services qs
        INNER JOIN 
            services s 
        ON
            qs.service_id = s.service_id 
        AND
            qs.job_id = s.job_id
        WHERE
            s.job_id=#{job_id}
        AND
            s.service_id
        IN
        <foreach item="item" index="index" collection="shifts" open="(" separator="," close=")">
            #{item}
        </foreach>
        );
</select>