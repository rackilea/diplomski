@RequestMapping(path = "/createOrderList", method = RequestMethod.POST)
public String createOrderList(@RequestBody String shopCart, Model model)
        throws JsonParseException, JsonMappingException, IOException {
    Order order = new Order();
    Float totalPrice = 0f;
    order.setCreationDate(new Date());
    List<String> bookIdList = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();
    ShoppingCart shpCart = mapper.readValue(shopCart, ShoppingCart.class);
    for (Book book : shpCart.getBookList()) {
        bookIdList.add(book.getId());
        totalPrice = totalPrice + book.getPrice();
    }
    order.setItemList(bookIdList);
    order.setTotalOrder(totalPrice);
    orderRepo.save(order);
    model.addAttribute("orderList", orderRepo.findAll());
    model.addAttribute("bookList", bookRepo.findAll());
    model.addAttribute("addedOrder", order);
    return "bookStore";
}