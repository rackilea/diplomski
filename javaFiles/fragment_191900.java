class MenuAdapter extends ArrayAdapter<String> {

    ....

    public boolean isEnabled(int position) {
        return position >= 10;
    }
}