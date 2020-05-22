@Override
public void OnClick(int position, View view) {

    if (R.id.imageLike == view.getId()){
        Toast.makeText(getContext(), "IMAGE LIKE CLICKED",Toast.LENGTH_SHORT).show();
        OpenDialog();
    }

    if (R.id.layoutRelative == view.getId()){
        Toast.makeText(getContext(), "ROW CLICKED", Toast.LENGTH_SHORT).show();
        OpenDatabase();
    }
}