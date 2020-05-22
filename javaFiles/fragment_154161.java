//The place where you have called this below method
@RequestMapping(value = "/sheet", method = RequestMethod.POST)
public ModelAndView saveRequirement

//You can get data in a Integer List as below
boolean report = true;
Map<Integer,Integer> itemCodeList = req.getItemCodeList();
Set<Integer> keys = itemCodeList.keySet()
for(Integer key : keys ){
    if(!(report = compare(itemCodeList, item)))
        break;
}

if(report)
    //code for generate report here... or redirection code as per your logic