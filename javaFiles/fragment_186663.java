@RequestMapping("/quotes")
@ResponseBody
public DeferredResult<String> quotes() {
  DeferredResult<String> deferredResult = new DeferredResult<String>();
  // Add deferredResult to a Queue or a Map...
  return deferredResult;
}


// In some other thread...    <-- important phrase
 deferredResult.setResult(data);
// Remove deferredResult from the Queue or Map