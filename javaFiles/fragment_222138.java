public class FilterableTableConfigurationBuilder 
    extends AbstractTableConfigurationBuilder<FilterableTableConfigurationBuilder> {

    public FilterableTableConfigurationBuilder() {
        super();
        this.filterable();
    }
}

public class FilterablePaginatedTableConfigurationBuilder 
    extends FilterableTableConfigurationBuilder {

    public FilterablePaginatedTableConfigurationBuilder() {
        super();
        this.paginated();
    }
}

public class SortablePaginatedTableConfigurationBuilder 
    extends AbstractTableConfigurationBuilder
            <SortablePaginatedTableConfigurationBuilder> {

    public SortablePaginatedTableConfigurationBuilder() {
        super();
        this.sortable().paginated();
    }
}