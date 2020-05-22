List<Models> models = new ArrayList<>();
String[] lines = result.split("\n");
for (String line : lines) {
    String[] items = line.split(":");
    Model model = new Models();
    model.setmUserName(items[0]);
    model.setmPassword(items[1]);
    model.setMlevel(Integer.valueOf(items[2]);
    models.add(model);
}