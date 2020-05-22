public static class Products {
        HashMap<String, String> productList = new HashMap<String, String>();

        public Products() {
            productList.put("p1", "Mocha");
            productList.put("p2","Latte");
        }

        public String getProductName(String productID){
            return productList.get(productID);
        }
    }