@RequestMapping(value="/Prova" ,  method=RequestMethod.POST)
@Transactional( propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public @ResponseBody  List<String>   Prova(
    HttpServletRequest request, HttpServletResponse response
    ) throws Exception
{    
  log.error("Sono qui");
  List<String> ret = new ArrayList<String>();
  ret.add("pippoPlutoTopolino");
  return ret;        
}