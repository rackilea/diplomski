public class MultipleSorting<T extends Enum<?>> {
    private Class<T> criteriaType;

    MultipleSorting(Class<T> criteriaType) {
        this.criteriaType = criteriaType;
    }

    public Class<T> getCriteriaClass() {
        return criteriaType;
    }
}

public abstract class MultiSortPageableController<T extends MultiSortPageableController<?, ?>, U extends Enum<?>> {
    private MultipleSorting<U> multipleSorting;

    public MultiSortPageableController(Class<U> criteriaType) {
        super();

        multipleSorting = new MultipleSorting<U>(criteriaType);
    }
}

public abstract class AbstractArticleSearchController<T extends AbstractArticleSearchController<T>> extends MultiSortPageableController<T, ArticleSortField> {
    public AbstractArticleSearchController() {
        super(ArticleSortField.class);
    }
}