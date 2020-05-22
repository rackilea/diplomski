<sql id="DOWNLOAD_FIELD_TYPES">
    #{key,jdbcType=VARCHAR},
    #{request.filter},
    #{status,jdbcType=OTHER},
    #{size,jdbcType=BIGINT},
    #{request.format,jdbcType=OTHER},
</sql>