@RequestMapping ("url/to/save")
@ResponseBody
public ResponseObject send (@RequestBody RequestObject myRequestObject)
{
   //do something

   return new ResponseObject ();
}