public class InvestmentResolver extends TypeIdResolverBase {

    @Override
    public JavaType typeFromId(DatabindContext context, String id) throws IOException {
        Investment investment = InvestmentFactory.getTypeFromString(type);
        return context.constructType(investment.getClass());
    }