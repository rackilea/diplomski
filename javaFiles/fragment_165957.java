@Select("{ #{outParam, jdbcType=NUMERIC, mode=OUT} = CALL ORA_FUNC( "
    + "#{pNum1, jdbcType=NUMERIC, mode=IN},"
    + "#{pNum2, jdbcType=NUMERIC, mode=IN},"
    + "#{pNum3, jdbcType=NUMERIC, mode=IN} )}")
@Options(statementType = StatementType.CALLABLE)
public void executeFunction(
    SpInOut inOut);