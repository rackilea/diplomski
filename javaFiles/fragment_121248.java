@RequestMapping(value="/createPOST", method = RequestMethod.POST)
  @ResponseBody
  public ResponseData createPOST(@RequestBody User user) {
    userDao.save(user);
    return new ResponseData(true, Arrays.asList(user));
  }