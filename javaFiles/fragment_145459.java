List<TextField> list = new ArrayList<>();
for (Control item : allControls) {
    if (item instanceof TextField) {
        list.add((TextField) item);
    }
}