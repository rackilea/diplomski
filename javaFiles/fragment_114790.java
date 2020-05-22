@RequestMapping(value="{userid}",method=RequestMethod.GET)
public @ResponseBody SomeResponseDto getIterationInfoInJSON(@PathVariable int userid) {
    // code
    SomeResponseDto dto = new SomeResponseDto();
    dto.setIterationInfos(listiterationinfo);
    dto.setAnotherPojoClasses(anotherPojoClasses);
    return dto;
}