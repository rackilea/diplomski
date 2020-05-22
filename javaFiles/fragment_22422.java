tr2.translate(
    (this.getWidth()/2) - (r.getWidth()*(zoom))/2,
    (this.getHeight()/2) - (r.getHeight()*(zoom))/2
);
tr2.scale(zoom,zoom);
g.setTransform(tr2);