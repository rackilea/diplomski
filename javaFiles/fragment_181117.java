String toJSON(ArrayList<Domain> list) {
    Gson gson = new Gson();
    StringBuilder sb = new StringBuilder();
    for(Domain d : list) {
        sb.append(gson.toJson(d));
    }
    return sb.toString();
}