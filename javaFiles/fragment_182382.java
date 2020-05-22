class Website {
        String title;
        String url;
}


Type type = new TypeToken<List<Website>>() {}.getType();
List<Website> list = new Gson().fromJson(actions, type);