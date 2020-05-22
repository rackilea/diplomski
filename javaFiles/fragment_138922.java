ArrayList<Product> shipment = new ArrayList<Product>();  // this is another list of items
ArrayList<Product> shipment = new ArrayList<>();   // same as above, only shorter :) you don't need to write <Product> in the new-statement


Product car = new Product();    // create your items like before        
Product toothbrush = new Product(); 

shipment.add(car);             // add all new items to the new list
shipment.add(toothbrush);

productInfo.addAll(shipment);  // add the complete list to your old list