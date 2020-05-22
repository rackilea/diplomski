public boolean onMarkerClick(final Marker marker) {
    linCard.setVisibility(View.VISIBLE);
    linCard.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            DAT_MARKER_OP datMarkerOp = markersMap.get(marker);
            if(datMarkerOp.getKODE_PAJAK() == 0) {
                // your logic
            }

        }
    });
}