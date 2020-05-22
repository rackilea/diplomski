public static void iterate(ArrayList<Model> modelList) {

    if (modelList == null) return;

    for (Model model : modelList) {
        System.out.println(model.toString());
        iterate(model.getArr());
    }
}