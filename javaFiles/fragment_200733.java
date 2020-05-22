/* This is the mouse listener for the top-level container. */
@Override
public void mouseClicked(MouseEvent e) {
    for(PileView pv : pileViews) {
        for(CardView cv : pv.cardViews) {
            if(cv.getBounds().contains(e.getPoint())) {
                cv.dispatchEvent(e);
            }
        }
    }
}