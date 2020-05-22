public class Filter {

    public <T> Set<T> filter(Set<T> all, Set<T> blocked) {
        for (T t : all) {
            if(blocked.contains(t)) {
                all.remove(t);
            }
        }
        return all;
    }
}