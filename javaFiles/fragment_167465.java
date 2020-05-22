public class MyReportEnabledWhitelist extends Whitelist {

    private Set<String> alreadyCheckedAttributeSignatures = new HashSet<>();

    @Override
    protected boolean isSafeTag(String tag) {
        boolean isSafe = super.isSafeTag(tag);

        if (!isSafe) {
            say("Disallowed tag: " + tag);
        }

        return isSafe;
    }

    @Override
    protected boolean isSafeAttribute(String tagName, Element el, Attribute attr) {
        boolean isSafe = super.isSafeAttribute(tagName, el, attr);

        String signature = el.hashCode() + "-" + attr.hashCode();
        if (alreadyCheckedAttributeSignatures.contains(signature) == false) {
            alreadyCheckedAttributeSignatures.add(signature);

            if (!isSafe) {
                say("Wrong attribute: " + attr.getKey() + " (" + attr.html() + ") in " + el.outerHtml());
            }
        }

        return isSafe;
    }
}