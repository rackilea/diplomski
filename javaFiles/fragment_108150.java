@Autowired
private DataSource dbMan;

 @RequestMapping("/check")
public ModelAndView greet() throws SQLException {

    //DbManager dbMan = new DbManager();

    if (dbMan.conn() != null) {
        return new ModelAndView("welcome", "msg", "SUCCESS");
    } else {
        return new ModelAndView("welcome", "msg", "FAIL");
    }

}