@ResponseBody    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String retweet(@RequestBody Long id) {
        twitterService.retweet(id);
        return "/";
    }