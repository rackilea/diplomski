@RequestMapping(value="/your-mapping", params = {"oldparam1", "oldparam2", ...})
public Whatever yourOldMethod(@RequestParam(value="oldparam1", required=true) String oldParam1, ...){
   return yourNewMethod(oldParam1, ...);
}

@RequestMapping(value="/your-mapping", params = {"newparam1", "newparam1", ...})
public Whatever yourNewMethod(@RequestParam(value="newparam1", required=true) String oldParam1, ...){
   //do whatever you need to do here
}