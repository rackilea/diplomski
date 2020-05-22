@Override
  public boolean onItemLongClick(AdapterView<?> parent, View view,
                                 int position, long id) {
    getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
    getListView().setItemChecked(position, true);

    return(true);
  }