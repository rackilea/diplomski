new InputStreamBody(f, snap_url.getLastPathSegment()) {

    public long getContentLength() {
        return /*your length*/;
    }
}