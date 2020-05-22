@GetMapping("/employee")
public List<Employee> getEmployee(@RequestParam(defaultValue = "empty") String name, @RequestParam(defaultValue = "empty") String designation, ....
{
    // check which one is not empty and perform logic
    if (!name.equals("empty")) {
      // do something 
  }
}