@RequestMapping(method = RequestMethod.GET)
public void getUpdatedApk(
        @RequestParam(value = "versionCode", required = true) final Integer versionCode,
        @RequestParam(value = "androidVersion", required = false) final Integer androidVersion,
        final HttpServletRequest request, 
        final HttpServletResponse response) throws Exception{

    apkUpdateService.getUpdate(new Long(versionCode), response);

}