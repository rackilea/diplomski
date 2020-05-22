// The app name is the application name of the deployed EJBs. This is typically the ear name
// without the .ear suffix. However, the application name could be overridden in the application.xml of the
// EJB deployment on the server.
// Since we haven't deployed the application as a .ear, the app name for us will be an empty string
final String appName = "";
// This is the module name of the deployed EJBs on the server. This is typically the jar name of the
// EJB deployment, without the .jar suffix, but can be overridden via the ejb-jar.xml
// In this example, we have deployed the EJBs in a jboss-as-ejb-remote-app.jar, so the module name is
// jboss-as-ejb-remote-app
final String moduleName = "jboss-as-ejb-remote-app";
// AS7 allows each deployment to have an (optional) distinct name. We haven't specified a distinct name for
// our EJB deployment, so this is an empty string
final String distinctName = "";
// The EJB name which by default is the simple class name of the bean implementation class
final String beanName = TestService.class.getSimpleName();
// the remote view fully qualified class name
final String viewClassName = TestServiceRemote.class.getName();

String jndiName= "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;

TestServiceRemote service = (TestServiceRemote)context.lookup(jndiName);