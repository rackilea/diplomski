for (OverlayItem overlay : overlays) {              
    Drawable marker = boundCenterBottom(context.getResources().getDrawable(markerId));
    marker.mutate();
    if (/* some condition */) {           
        marker.setAlpha(100);
    }

    overlay.setMarker(marker);
}