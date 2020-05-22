final ListView lv = getListView();
lv.clearChoices();
for (int i = 0; i < lv.getCount(); i++)
    lv.setItemChecked(i, false);
lv.post(new Runnable() {
    @Override
    public void run() {
        lv.setChoiceMode(ListView.CHOICE_MODE_NONE);
    }
});