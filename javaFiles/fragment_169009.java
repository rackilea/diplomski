@ManagedBean(name="bean1")
@SessionScoped
public class Bean1 {
    @ManagedProperty(value="#{bean2}")
    private Bean2 ncpForm;
    ....
}