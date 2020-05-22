public class FulltextsearchPlugin extends DefaultSessionPlugin {  
private final Analyzer analyzer = new StandardAnalyzer();  
private final String path = "c:/temp/lucene/squirrel/";  
private final IndexWriter writer = createIndexWriter();  

@Override  
public String getAuthor() {  
    return "Mike Haller";  
}  

@Override  
public String getDescriptiveName() {  
    return "Full-Text Search Plugin";  
}  

@Override  
public String getInternalName() {  
    return "fulltextsearchplugin";  
}  

@Override  
public String getVersion() {  
    return "0.0.1";  
}  

@Override  
public PluginSessionCallback sessionStarted(ISession session) {  
    // Add context menu items to the object tree's view and procedure nodes.  
    IObjectTreeAPI otApi = session.getSessionInternalFrame()  
            .getObjectTreeAPI();  
    otApi.addToPopup(DatabaseObjectType.TABLE, new FulltextsearchMenu(this,  
            session));  
    return new PluginSessionCallbackAdaptor(this);  
 }  
}