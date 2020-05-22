class Column
{
    int xposition;
    int usage;

    public static final Comparator<Column> SortByX = new Comparator<Column>() {
        @Override
        public int compare(Column c1, Column c2)
        {
            return Integer.compare(c1.xposition, c2.xposition);
        }
    };

    public static final Comparator<Column> SortByUsage = new Comparator<Column>() {
        @Override
        public int compare(Column c1, Column c2)
        {
            return Integer.compare(c1.usage, c2.usage);
        }
    };
}

TreeSet<Column> cols = new TreeSet<>(Column.SortByX);