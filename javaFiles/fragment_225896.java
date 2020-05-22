@Named("myBean")
@SessionScoped
public class MyBean implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(MyBean.class);
    private static final long serialVersionUID = 1L;
    private long taskId;
    @EJB
    private MyEjb myEjb;