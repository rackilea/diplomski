public class SessionListener implements HttpSessionListener {

  public void sessionCreated(HttpSessionEvent event) {

    HttpSession session = event.getSession();

    // get list of possible data sources available to this session
    List<DataSource> sources = new ArrayList<DataSource>();
    ... code to get the available sources

    // get the current data source
    DataSource source = null;
    ... code to get the current source                               
    source = sources.get(0); // for example

    // setup the session attributes
    session.setAttribute("availableSources", sources);
    session.setAttribute("currentSource", source); 

  }

}