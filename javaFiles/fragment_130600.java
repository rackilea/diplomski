Component component = new Component();
Supplement supplement = new Supplement();
ComponentSupplement cs = new ComponentSupplement();
cs.setComponent(component);
cs.setSupplement(supplement);
em.persist(cs);