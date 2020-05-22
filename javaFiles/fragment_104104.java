if (productId != null) {

            // get selected product
            selectedProduct = productFacade.find(Short.parseShort(productId));

            // place selected product in session scope
            session.setAttribute("selectedProduct", selectedProduct);
        }