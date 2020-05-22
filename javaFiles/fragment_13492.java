Public Class Inof
{
    private String fromDate;
    private String fromDate;
    private List<User> list;

}

<select id="" parameterClass="myPackage.Inof" resultMap="">
    SELECT * from myTable WHERE  fromDate>= #fromDate# and toDate<=#toDate# and name IN 
     <iterate open="(" close=")" conjunction="," property="list"  >
     #list[].name#
    </iterate>
     and location  IN 
     <iterate open="(" close=")" conjunction="," property="list"  >
     #list[].location#
    </iterate>
</select>