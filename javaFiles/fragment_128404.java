public interface PopulationMember<T extends PopulationMember> extends Comparable<T> {
    int compareTo(T o);
    T merge(T o);
    // Some other stuff

}