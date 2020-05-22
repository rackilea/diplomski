Class policyClass = Class.forName(POLICY_IMPL_CLASS_NAME);
sPolicy = (IPolicy)policyClass.newInstance();

public static Window makeNewWindow(Context context) {
    return sPolicy.makeNewWindow(context);
}