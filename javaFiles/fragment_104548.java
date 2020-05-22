@Override
@Transactional
public void sessionCreated(HttpSessionEvent event) {
    log.trace("sessionCreated(): "+event.getSession().getId());

    JdbcTemplate select = new JdbcTemplate(getDS(event));
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String datetime = sdf.format(Calendar.getInstance().getTime());

    select.update("INSERT INTO sessions (username, session, started) VALUES ('','"+event.getSession().getId()+"','"+datetime+"')");
}
private DataSource getDS(HttpSessionEvent event){
    HttpSession session = event.getSession();

    ApplicationContext ctx = 
        WebApplicationContextUtils.
              getWebApplicationContext(session.getServletContext());

    DataSource dao = 
                  (DataSource) ctx.getBean("BPSCoreDS");

    return dao;
}