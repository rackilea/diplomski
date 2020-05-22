<select id="callStoredProcedure" statementType="CALLABLE"
    resultMap="outputResultMap">
  {call MY_PROC(
  #{SP_FirstName,mode=IN,jdbcType=NVARCHAR},
  #{SP_LastName,mode=IN,jdbcType=NVARCHAR},
  #{SP_Gender,mode=IN,jdbcType=NVARCHAR},
  #{SP_Birthday,mode=IN,jdbcType=DATE},
  #{SP_Age,mode=IN,jdbcType=BIGINT}
  )}
</select>