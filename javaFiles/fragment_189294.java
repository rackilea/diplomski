@RequestMapping(value="/canvass/test", method = RequestMethod.POST)
public void createTest(@RequestBody TestObj tobj) 
        throws ServiceOperationException {
    // test method
    int i = 0;
    System.out.println(i);
}