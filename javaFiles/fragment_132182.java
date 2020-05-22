/* The user's name is "Foo" and he is of type "admin"*/
User user = getUserFromDatabase("Foo");

/* You would not add hard coded content in real world.
 * it is just to show how template engines work */
String message = "Hello,";

Velocity.init(); /* Initialises the Velocity engine */

VelocityContext ctx = new VelocityContext();

/* the user object will be available under the name "user" in the template*/
ctx.put("user",user); 
/* message as "welcome" */
ctx.put("welcome",message);

StringWriter writer = new StringWriter();

Velocity.mergeTemplate("myTemplate.vm", ctx, writer);

System.out.println(writer);