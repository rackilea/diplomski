public class TenantContext {

    private static final ThreadLocal<String> currentTenant  = new ThreadLocal<>();

    public static void setCurrentTenant(String tenant) {
        Assert.notNull(tenant, "clientDatabase cannot be null");
        currentTenant.set(tenant);
    }

    public static String getClientDatabase() {
        return currentTenant .get();
    }

    public static void clear() {
        currentTenant .remove();
    }

}