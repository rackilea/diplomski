Cart cart = (Cart) session.getAttribute("cart");

if (cart == null) {
    cart = new Cart();
    session.setAttribute("cart", cart);
}

// ...