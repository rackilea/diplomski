@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OfficeContext implements InitializingBean, Office {

   private Office office;

   @Autowired
   private UserDao userDao;

   @Autowired
   private NoneOffice noneOffice;
   @Autowired
   private AllOffice allOffice;
   @Autowired
   private TariffOffice tariffOffice;
   @Autowired
   private ArzeshOffice arzeshOffice;

    public Office getOffice() {
       return this.office;
    }

   @Override
   public void afterPropertiesSet() throws Exception {
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       if (auth.isAuthenticated()) {
           String name = auth.getName(); //get logged in username
           JUser user = userDao.findByUsername(name);
           if (user != null) {
               this.office = noneOffice;
           } else {
               OfficeType type = user.getOfficeType();
               switch (type) {
                   case ALL:
                       this.office = allOffice;
                       break;
                   case TARIFF:
                       this.office = tariffOffice;
                       break;
                   case ARZESH:
                       this.office = arzeshOffice;
                       break;
                   default:
                       this.office = noneOffice;
               }
           }
       } else {
           this.office = noneOffice;
       }

   }

   @Override
   public OfficeType getType() {
       return office.getType();
   }

   @Override
   public String getDisplayName() {
       return office.getDisplayName();
   }

}