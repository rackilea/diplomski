@RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody ResponseMsg login(@RequestHeader(value="username", required=false) String userName, 
            @RequestHeader(value="password", required=false) String password ) {

        ResponseMsg responseMsg = CommonUtils.checkParam(userName, password);
        if(responseMsg.getStatus().equalsIgnoreCase("True"))
            responseMsg =  userService.login(userName, password);
        return responseMsg;
    }