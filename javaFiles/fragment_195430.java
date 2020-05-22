@RequestMapping(value = "/all", method = RequestMethod.GET)
@ResponseBody
public List<Object[]> getAllDeps() {
    List<Object[]> list  = departmentService.getAllDepartments();
    return list;
}