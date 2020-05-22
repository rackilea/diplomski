if (result.containsKey(PLAYER_NAME) && result.get(PLAYER_NAME).size() == 2) {
    List<Material> list = result.get(PLAYER_NAME);
    Material first = list.get(0);
    Material second = list.get(1);
    if (first == Material.FIRST && second == Material.SECOND || first == Material.SECOND && second == Material.FIRST) {
        //Don't cancel the event
    }
}