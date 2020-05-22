@RequestMapping("/getList")
    public ModelAndView getNetAllList( MYObject myObj)  {

//my code here

}

<form name="myForm"  th:action="@{/getList}" th:object="${myObject}" method="post">