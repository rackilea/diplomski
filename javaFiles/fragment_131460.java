List<MyClass> list =
DSL.using(configuration)
   .select()
   .from(CUSTOMER)
   .join(PRODUCT)
   .on(CUSTOMER.ID.eq(PRODUCT.CUSTOMER_ID))
   .fetchInto(MyClass.class);