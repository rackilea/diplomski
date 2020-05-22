@RequestMapping("/")
public View requestHandler() throws SomeException
{
  // ...
}

@ExceptionHandler(SomeException.class)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public @ResponseBody String handleSomeException(SomeExcption ex)
{
  return ex.getMessage(); // for example
}