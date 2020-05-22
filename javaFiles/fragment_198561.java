String[] selection = request.getParameterValues("food");

Map<String, String> foodPrices = new HashMap<String, String>(selection.length);
for (String option: selection) {
    String[] foodPrice = option.split("=");
    foodPrices.put(foodPrice[0], foodPrice[1]);
}

application.setAttribute("foodMap", foodPrices);