@ResponseStatus(value = HttpStatus.OK)
@RequestMapping(value = COUNTRY_PATH + DELETE_PATH + SLASH + "{" + DELETE_ID_PARAM + "}", method = RequestMethod.DELETE)
public void delete(@PathVariable(DELETE_ID_PARAM) Integer deleteId, @RequestParam  Object data)  {
    System.out.println(data.toString());
    countryService.deleteCountry(deleteId);
}