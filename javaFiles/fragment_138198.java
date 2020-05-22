@Override
public Gift getItem(int position) {
    if(this.giftz2 != null) {
        this.giftz2.get(position);
    } else {
        return null;
    }
}