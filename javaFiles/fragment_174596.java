private List<SelectItem> domains = new ArrayList<SelectItem>();
//for each domain
domains.add("com",firstFromDomainSelection);
domains.add("net",secondFromDomainSelection);

<f:selectItems value="#{Bean.domains}" />