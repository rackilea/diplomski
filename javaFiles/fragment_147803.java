@ManagedBean
@ViewScoped
public class MyBean {

    private Long id;

    public void validate(FacesContext context, UIComponent component, Object object) {
        // Do some validation
        // And if failed:
        context.getExternalContext().setResponseStatus(404);
        context.responseComplete();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}