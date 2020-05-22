JavascriptContext context;
//initialization of [context] and loading HTML 
JSObject window = context.getWindow();
window.call("setName", new Object[]
{
      "Moslim"
});