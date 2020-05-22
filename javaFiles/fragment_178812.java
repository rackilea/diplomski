@ManagedBean(eager = true)
@ApplicationScoped
public class EnvoiPeriodiqueApp implements Serializable {

    private static final long serialVersionUID = 1L;

    @PostConstruct
    public void initBean() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        System.out.println(servletContext.getRealPath("/"));
    }
}