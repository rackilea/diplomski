public List<User> getLdapQueryResult(final LdapName dn, final Filter filter) throws NamingException {
    final PagedResultsDirContextProcessor processor = new PagedResultsDirContextProcessor(getPageSize());
    final SearchControls searchControls = new SearchControls();
    final UserContextMapper ucm = new UserContextMapper();
    searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
    return SingleContextSource.doWithSingleContext(
            ldapTemplate.getContextSource(), new LdapOperationsCallback<List<User>>() {
        @Override
        public List<User> doWithLdapOperations(LdapOperations operations) {
            List<User> result = new LinkedList<User>();
            do {
                List<User> oneResult = operations.search(dn, filter.encode(), searchControls, ucm, processor);
                result.addAll(oneResult);
            } while (processor.hasMore());
            return result;
        }
    });
}