Sale sale = new Sale();
Pk pk = new Pk(saleAssistant.getId(), customer.getId(), product.getId());
sale.setPk(pk);
sale.setSoldBy(saleAssistant);
sale.setBuyer(customer);
sale.setProduct(product);
...