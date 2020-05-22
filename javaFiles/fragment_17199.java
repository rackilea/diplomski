public class ServiceEventComparator implements Comparator<ServiceEvent> {
    @Override
    public int compare(ServiceEvent e1, ServiceEvent e2) {
        return e1.getTimeChanged().compareTo(e2.getTimeChanged());
    }
}