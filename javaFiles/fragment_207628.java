public class HibernateReverseEngineeringStrategy extends DelegatingReverseEngineeringStrategy {

public HibernateReverseEngineeringStrategy(ReverseEngineeringStrategy delegate) {
    super(delegate);
}

@Override
public String tableToClassName(TableIdentifier tableIdentifier) {
    return super.tableToClassName(tableIdentifier) + "Entity";
}

}