public class TenantProvider implements TenantIdProvider {

    @Override
    public String provideTenantIdForProcessInstance(TenantIdProviderProcessInstanceContext ctx) {
        return (String) ctx.getVariables().get("tenantId");
    }

    @Override
    public String provideTenantIdForCaseInstance(TenantIdProviderCaseInstanceContext ctx) {
        return (String) ctx.getVariables().get("tenantId");
    }

    @Override
    public String provideTenantIdForHistoricDecisionInstance(TenantIdProviderHistoricDecisionInstanceContext ctx) {
        return (String) ctx.getExecution().getVariable("tenantId");
    }
}