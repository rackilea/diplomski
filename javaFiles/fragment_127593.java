public abstract class HierarchyFormatter {
    protected final Hierarchy hierarchy;

    public HierarchyFormatter(Hierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }

    public abstract String format();
}

public class BraceFormatter extends HierarchyFormatter {
    public String format() {
        //...
    }
}

public class RangeFormatter extends HierarchyFormatter {
    public String format() {
        //...
    }
}