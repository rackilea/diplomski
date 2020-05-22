public View selectItemForOrder(HttpSession session) {

session.setAttribute(XXXX,YYY);
return View;
}

public View finishOrder(HttpSession session) {
Session.getAttribute(XXXX)
System.out.println("Shop id: " + getExecutingShopId());
computeOrder(executingShopId);
return View;
}