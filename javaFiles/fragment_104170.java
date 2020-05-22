<insert id="saveStripperDetails">
        INSERT INTO EXOTIC_DANCERS (STRIPPER_ID, STAGE_NAME, REAL_NAME)
        VALUES
        <foreach item="stripper" collection="input" separator=",">
            (#{stripper.stripperID},
            #{stripper.stripperName},
            #{stripper.realName})
        </foreach>
    </select>