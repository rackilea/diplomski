Category category = new Category();
AbstractPolicyRule policyRule1 = new AbstractPolicyRule("foo");

category.addToActivePolicyRules(policyRule1);
em.persist(category);
em.flush();

assertNotNull(category.getId());
assertNotNull(category.getActivePolicyRules());
assertEquals(1, category.getActivePolicyRules().size());

category.removeFromActivePolicyRules(policyRule1);
category.addToActivePolicyRules(new AbstractPolicyRule("bar"));
// category = em.merge(category); // works with or without
em.flush();
assertEquals(1, category.getActivePolicyRules().size());