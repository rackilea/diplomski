private boolean highlighted = false;
private Integer from, to;
//....
public void setHighlight(int from, int to) {
    if ((this.from != null && this.from == from) && (this.to != null && this.to == to)) {
        highlighted = false;
        this.from = null;
        this.to = null;
    } else {
        highlighted = true;
        this.from = from;
        this.to = to;
    }
}
//...
@Override
public View getView(int pos, View v, ViewGroup vg) { 
    parsedLine entry = lines.get(pos);
    //...
    if (highlighted && pos>=from && pos<=to){
        v.setBackgroundColor(Color.parseColor(Theme.getHighlightColor()));
    } 
    //...
    return v;
}