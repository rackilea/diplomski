public void someBusinessLogic() {
   while (!done) {
     InputStream is = ...
     template.sendBody("direct:routeMe", is);

     ...
     // logic to know if we should continue or break out
   }
}

from("direct:routeMe")
  .to("stream:out");