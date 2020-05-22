Domain domain = new Domain();
domain.setName(domainString);
domainFacade.create(domain);

List<Domain> domains = new ArrayList<Domain>();
domains.add(domain);


problem.setDomains(domains);
problemFacade.create(problem);