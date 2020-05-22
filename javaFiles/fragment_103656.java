@Component
@Scope(value = "request", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class ListX {
    private List<Long> listLong = new ArrayList<Long>();

    public List<Long> getListLong() {
        return listLong;
    }

    public void setListLong(List<Long> listLong) {
        this.listLong = listLong;
    }
}