String code = jsonObj.opt("code");
if(!arrayList.contains(code))
{
    arrayList.add(code);
    responseObj.put("id", jsonObj.opt("id")); 
    responseObj.put("code", jsonObj.opt("code")); 
    responseObj.put("long_description", long_description);
    responseObj.put("description", description);
}