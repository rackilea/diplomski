//"produces" will tell Spring to which format convert the data
//"method" will tell Spring which HTTP method should be handled for this URL
@RequestMapping(value="/student",
    produces="application/json; charset=UTF-8",
    method=RequestMethod.GET)
public @ResponseBody Student getStudent(){
    return new Student(2, "h");
}