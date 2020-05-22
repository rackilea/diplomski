/* when submit button is clicked... Form is submitted for saving*/  
@RequestMapping(value="/account/{accountid}", method=RequestMethod.POST)  
    public String submitForm(@PathVariable String accountid, @RequestBody Account account){  
        // save here  
        return "myform";  
}