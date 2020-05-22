@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getEmployee(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee", employeeDao.find(id));
        model.addAttribute("departments", departmentDao.list());
        return "employees/view";
    }