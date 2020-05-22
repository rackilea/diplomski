@RequestMapping(value = 'call', method = RequestMethod.Get, produces="application/json")
public @ResponseBody String getSampleObjects(HttpServletRequest request) 
{
     List<SampleObject> sampleList = new ArrayList<SampleObject>();
     sampleList.add(new SampleObject());
     Gson gson =  new Gson();
     return gson.toJson(sampleList);
}