@RequestMapping("/getList")
    public ModelAndView getNetAllList(@ModelAttribute("myObjVO") MYObject myObj)  {

//my code here

}

<form name="myForm"  th:action="@{/getList}" th:object="${myObjVO}" method="post">