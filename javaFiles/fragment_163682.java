prefixMap = QueryUtils.parsePrefixes(prefix);
WhereClause whereClause = QueryUtils.parseWhere(where, prefixMap);

PName property = null;
String value ="";
for (SimpleTerm term : whereClause.children())
{
    ComparisonTerm comparison = (ComparisonTerm)term;
    String operator;

    switch (comparison.operator())
    {
        case EQUALS:
            operator = "equals";
            break;
        case NOT_EQUALS:
            operator = "notequals";
            break;
        case LESS_THAN:
            operator = "lessthan";
            break;
        case LESS_EQUALS:
            operator = "lessthaneq";
            break;
        case GREATER_THAN:
            operator = "greaterthan";
            break;
        default:
        case GREATER_EQUALS:
            operator = "greaterhaneq";
            break;
    }         
    property = comparison.property();       
    Value operand = comparison.operand();
    value = operand.toString();
    switch (operand.type())
    {
        case STRING:
        case URI_REF:
            value = value.substring(1, value.length() - 1);
            break;
        case BOOLEAN:
        case DECIMAL:
            break;
        default:
        throw new WebApplicationException
        (new UnsupportedOperationException("Unsupported oslc.where comparison operand: " + value),Status.BAD_REQUEST);                
     }
 }
 String compareString=property.toString().substring(property.toString().indexOf(":")+1);
 String val="get" + compareString.substring(0,1).toUpperCase() +compareString.substring(1);
 final Project[] changeRequests = Persistence.getChangeRequestsForProject();
 for (final Project changeRequest : changeRequests)
 {
     changeRequest.setServiceProvider(ServiceProviderSingleton.getServiceProviderURI());
     Method m=changeRequest.getClass().getMethod(val, null);
     if((m.invoke(changeRequest).toString().equalsIgnoreCase(value)))
     {
         results.add(changeRequest);
     }
 }