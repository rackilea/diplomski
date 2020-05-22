@PostMapping(value = "/api_url")
public ResponseEntity<Object> suggestBreakfast(@RequestBody Map bothVar){
    System.out.println("value1 is : "+ bothVar.get("value1"));
    System.out.println("value2 is : "+ bothVar.get("value2"));
}
// And i am getting those two values here successfully