<update id="getFooFunction" statementType="CALLABLE">
  {#{result,jdbcType=INTEGER,mode=OUT} = call f_foo_function(
    #{foo,mode=IN},
    #{fooOutput,jdbcType=INTEGER,javaType=_boolean,mode=OUT}, 
    #{error,jdbcType=VARCHAR,mode=OUT})}
</update>