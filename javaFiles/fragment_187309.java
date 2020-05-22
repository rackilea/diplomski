product.setPrice(restrictions.gt(10)); // price > 10
 product.setPromo(restrictions.order(false)); // order by promo desc
 Restrictions<Manufacturer> manufacturerRestrictions 
        = Restrictions.create(Manufacturer.class);
 //configure manuf restrictions in the same manner...
 product.setManufacturer(restrictions.join(manufacturerRestrictions)); 
 /* there are also joinSet() and joinList() methods
  for one-to-many relationships as well */