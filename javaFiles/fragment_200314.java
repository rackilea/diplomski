@RequestMapping(value="/Prova2" ,  method=RequestMethod.POST)
@ResponseBody public StringBuffer Prova2(
        HttpServletRequest request
        ) throws Exception
{
  return new StringBuffer("pippoPlutoTopolino");  
}