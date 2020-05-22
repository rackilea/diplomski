public abstract class AbstractConfig {

    public String doStuff(List<Params> params) {
        if (performErrorChecks()) {
            return doTheActualStuff(params);
        }
        return null;
    }

    protected abstract String doTheActualStuff(List<Params> params);
}