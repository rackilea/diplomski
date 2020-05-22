public void start() {
    ...
    regex = optionList.get(0);
    pattern = Pattern.compile(regex);
    replacement = optionList.get(1);
    super.start();
}