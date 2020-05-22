public class RevengStrategy extends DelegatingReverseEngineeringStrategy  {

    public RevengStrategy(ReverseEngineeringStrategy delegate) {
        super(delegate);
    }

    @Override
    public boolean excludeForeignKeyAsManytoOne(String keyname, TableIdentifier fromTable, List fromColumns, TableIdentifier referencedTable, List referencedColumns) {
        return true;
    }

    @Override
    public boolean excludeForeignKeyAsCollection(String keyname, TableIdentifier fromTable, List fromColumns, TableIdentifier referencedTable, List referencedColumns) {
        return true;
    }

}