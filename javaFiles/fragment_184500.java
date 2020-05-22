@RequestMapping(value="/getCrimeTypeList.htm", method = RequestMethod.GET)
public @ResponseBody List<CrimeType> getCrimeTypeList(@RequestParam(value="crimeCatId") Integer crimeCatId) throws Exception{    
            try {
                return this.crimeTypeManager.getCrimeTypeList(crimeCatId);
                //return "true";
            } catch (Exception e) {
                logger.error(e.getMessage());
                return null;
            }
}