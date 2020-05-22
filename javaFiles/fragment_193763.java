@RequestMapping(value ="test", method = RequestMethod.POST)
@ResponseStatus(HttpStatus.OK)
@ResponseBody
public Person updatePerson(@RequestParam("arg1") String arg1,
        @RequestParam("arg2") String arg2,
        @RequestBody Person input) throws IOException {
    System.out.println(arg1);
    System.out.println(arg2);
    input.setName("NewName");
    return input;
}