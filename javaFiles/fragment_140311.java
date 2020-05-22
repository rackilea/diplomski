@RestController
public class GreetingController {

    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @PostMapping(path = "/departments", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    Departments newEmployee(@RequestBody List<Department> departments) {
            Departments departmentsObj = new Departments();
            for(Department department : departments) {
                System.out.println(department);
            }
        departmentsObj.setDepartment(departments);

        return departmentsObj;
    }
}