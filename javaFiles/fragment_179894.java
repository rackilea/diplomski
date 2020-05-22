// Define the policy.
Function<HtmlStreamEventReceiver, HtmlSanitizer.Policy> policy
    = new HtmlPolicyBuilder()
        .allowElements("pre")
        .toFactory();

// Sanitize your output.
HtmlSanitizer.sanitize(myHtml, policy.apply(myHtmlStreamRenderer));