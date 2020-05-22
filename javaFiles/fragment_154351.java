List<ProductManager> B = A.stream().map(developer -> {
            ProductManager productManager = new ProductManager();
            try {
                PropertyUtils.copyProperties(productManager, developer);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return productManager;
        }).collect(Collectors.toList());

        B.forEach(System.out::println);