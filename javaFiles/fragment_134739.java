public final class SearchableList<T extends Searchable> extends AbstractList<T> implements Searchable {

    private final List<T> list;

    SearchableList(List<T> list) {
        this.list = list;
    }

    // rest omitted
}