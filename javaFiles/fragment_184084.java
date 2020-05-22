@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Department.class, new DepartmentEditor(departmentDao));
    }
@RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String updateEmployee(@PathVariable("id") long id, @ModelAttribute Employee employee) {
        employee.setId(id);
        employeeDao.update(employee);
        return "redirect:/employees";
    }