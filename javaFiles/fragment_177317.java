@RequestMapping(value = "/{username}/updateImage", method = RequestMethod.POST)
public @ResponseBody
ResponseEntity<AccountResource> updateAccountImage(@PathVariable("username") String username,
            @RequestParam("image") final MultipartFile file)throws IOException {


    AccountResource resource =new AccountResource();
                        resource.setImage(file.getBytes());
                        resource.setUsername(username);


    Account account = accountService.updateAccountImage(resource.toAccount());
    if (account != null) {
        AccountResource res = new AccountResourceAsm().toResource(account);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new ResponseEntity<AccountResource>(res,headers, HttpStatus.OK);
    } else {
        return new ResponseEntity<AccountResource>(HttpStatus.NO_CONTENT);
    }
}