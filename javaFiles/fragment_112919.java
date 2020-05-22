@RequestMapping("/employees")
public String showEmployees(Model model, @RequestParam(value="startDate") String startDate, @RequestParam(value="endDate") String endDate) {
    SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDD");
    Date start = sdf.parse(startDate);
    Date end = sdf.parse(endDate);
    model.addAttribute("employees", employeeService.getEmployees(start, end));

    return "employees";
}