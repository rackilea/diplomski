@RequestMapping("/getList")
public String getList(@RequestParam(value = "page", required = false) Integer page, Model model,
        @RequestParam(value = "page_size", required = false) Integer page_size) {
    if (page == null) {
        page = 0;
    }
    if (page_size == null) {
        page_size = 4;
    }
    List<Employee> empList = empService.getEmpList1(page, page_size);
    Employee emp = new Employee();

    model.addAttribute("employee", emp);
    model.addAttribute("empList", empList);
    model.addAttribute("page", page);
    model.addAttribute("page_size", page_size);
    return "empList";
}

//This for next button in jsp..... Try and let me know if this link work?
 <a href="getList?page=${page+1}&page_size=${page_size}">Next:</a>

//This is my Sql Query........
recordStart = page * page_size;
select * from EmpDetails LIMIT +recordStart+","+page_size;