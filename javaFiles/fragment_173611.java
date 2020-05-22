while ((line = bufferedReader.readLine()) != null){
  // line has already stored information about the Product type.
            Product product = new Product();
            product.setDescription(line); // set value using line variable
            // product.setDescription(bufferedReader.readLine()); // error
            product.setProductCode(bufferedReader.readLine());
            product.setUnitPrice(Integer.parseInt(bufferedReader.readLine()));
            System.out.println(product);
            products.add(product);
            }