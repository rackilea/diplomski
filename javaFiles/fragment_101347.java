Map<String, Object> props = new HashMap<String, Object>();
props.put("site-id", 0);
props.put("price-score", 0.5);
props.put("confidence-score", 0.2);
Map<String, Category> categories = new HashMap<String, Category>();
categories.put("123", new Category("0.4", "0.2"));
categories.put("321", new Category("0.2", "0.5"));
props.put("categories", categories);