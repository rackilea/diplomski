private String searchIdByName(String name) {
    for (int i = 0; i < mArrayList.size(); i++) {
        if (mArrayList.get(i).getName().equals(name)) {
            return mArrayList.get(i).getId();
        }
    }
    return null;
}