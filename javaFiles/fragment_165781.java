private JdbcTemplate template;
private EmailService service;

@Autowired
public PublicDao(JdbcTemplate jt, EmailService es) {
  this.template = jt;
  this.service = es;
}