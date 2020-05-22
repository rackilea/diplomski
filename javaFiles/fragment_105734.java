HttpSession session = request.getSession();
List lIngredients = (List) session.getAttribute("Ingredientes");

if (lIngredients == null) {
    List lIngredients = new ArrayList<>();
    session.setAttribute("Ingredientes", lIngredientes);
}