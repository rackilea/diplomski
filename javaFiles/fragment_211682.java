@Select("<script>select count(*) from enu " +
  " where appType in ( " +
  "<foreach item='appType' collection='appTypes' separator=','>" +
  "   #{appType,typeHandler=AppTypeTypeHandler}" +
  "</foreach>)</script>")
int countByType(@Param("appTypes") List<AppType> appTypes);