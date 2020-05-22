@Select({
    "<script>"
    , "SELECT * FROM `employees` WHERE `hire_date` "
    , "  BETWEEN
    , "  #{dateFrom,typeHandler=*.*.*.Null2DateTypeHandler}"
    , "  AND"
    , "  #{dateTo,typeHandler=*.*.*.Null2DateTypeHandler}"      
    ,"</script>"
})
@Results({
      @Result(property = "empNo", column = "emp_no"),
      @Result(property = "birthDate", column = "birth_date"),
      @Result(property = "firstName", column = "first_name"),
      @Result(property = "lastName",  column = "last_name"),
      @Result(property = "gender",    column = "gender"),
      @Result(property = "hireDate",  column = "hire_date")          
})  
List<Employees> selectBetweenTypeHandler(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);