DECLARE
    v_wb      ORA_JAVA.JOBJECT;
    v_hi      VARCHAR2(20);
BEGIN
    v_wb := hiworld.new();
    v_hi:= hiworld.getHi(v_wb);
    :TEXT_HI_WORLD := v_hi
END;