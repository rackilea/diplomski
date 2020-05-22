public class BootstrapServlet extends VaadinServlet {

private static final long serialVersionUID = 1L;

@Override
protected void servletInitialized() throws ServletException {
    super.servletInitialized();
    getService().addSessionInitListener(new SessionInitListener() {

        private static final long serialVersionUID = 1L;

        @Override
        public void sessionInit(SessionInitEvent event) {
            event.getSession().addBootstrapListener( new BootstrapListener() {

                private static final long serialVersionUID = 1L;

                @Override
                public void modifyBootstrapFragment(
                        BootstrapFragmentResponse response) {

                }

                @Override
                public void modifyBootstrapPage(BootstrapPageResponse response) {


                    if(response.getRequest().getHeader("User-Agent").contains("MSIE 8.0")){

                        response.getDocument().head().appendElement("script").attr("type", "text/javascript").attr("src", "https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js");
                        response.getDocument().head().appendElement("script").attr("type", "text/javascript").attr("src", "https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js");

                    }
                }}
            );
        }
    });
  }
}