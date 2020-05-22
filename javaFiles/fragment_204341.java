@Override
public void onItemClick(int pos) {

    Intent pDetail = new Intent(this.getContext(), ProfileDetail.class);//get the context
    ListItem listItem = listItems.get(pos);//get the position
    //Then your puEtxra here followed by start activity
    startActivity(pDetail);
}