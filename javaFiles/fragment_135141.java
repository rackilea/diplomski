@Override
public View getView(int position, View convertview, ViewGroup parent) {
    View view = super.getView(position, convertview, parent);

    int evenrow = ActionColorCoding.setHeadingColor(ctxt,
            callerintent,
            ActionColorCoding.getColorsPerGroup() -1 ) &
            ActionColorCoding.transparency_evenrow;
    int oddrow = evenrow & ActionColorCoding.transparency_oddrow;
    if (position % 2 == 0) {
        view.setBackgroundColor(evenrow);
    } else {
        view.setBackgroundColor(oddrow);
    }
    return view;
}