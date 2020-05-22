@GetMapping(path="/foo", produces="application/json")
public MyJSON foo() {
    MyJSON myJSON = new MyJSON("SUCCESS", "  ");
    myJSON.addEmployeeStatus(81, "Jack");
    myJSON.addEmployeeStatus(88, "Anthony");
    return myJSON;
}