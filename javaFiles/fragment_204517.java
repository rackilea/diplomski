@ManagedBean
@ViewScoped
public class Counties {

    private boolean accepted;

    public void viewReport() {
        if (some condition) {
            accepted = true;
        }
    }

    public boolean isAccepted() {
        return accepted;
    }

}