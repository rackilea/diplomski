import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;     
...

public void initializePlugin(PluginManager manager,File pluginDirectory) {
  ContextHandlerCollection contexts = 
  HttpBindManager.getInstance().getContexts();

  context = new WebAppContext(contexts,pluginDirectory.getPath(),"/"+NAME);
  context.setWelcomeFiles(new String[]{"index.html"});
...