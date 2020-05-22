Criteria baseCrit = session.createCriteria(Item.class).add(Example.create(sItem));
baseCrit.createCriteria("vehicle").add(Example.create(sItem.getVehicle()));
baseCrit.createCriteria("vmodel").add(Example.create(sItem.getVmodel()));
baseCrit.createCriteria("category").add(Example.create(sItem.getCategory()));
baseCrit.createCriteria("itemName").add(Example.create(sItem.getItemName()));
baseCrit.createCriteria("brands").add(Example.create(sItem.getBrands()));
baseCrit.createCriteria("sizeModel").add(Example.create(sItem.getSizeModel()));
list = baseCrit.list();