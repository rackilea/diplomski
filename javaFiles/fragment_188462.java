@ManagedBean
@ApplicationScoped
public class Data {

    public Transportmittel[] getTransportmittels() {
        return Transportmittel.values();
    }

}