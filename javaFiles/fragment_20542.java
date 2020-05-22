private void setDataSource(/* snip */) throws /* snip */ {
    /* snip */
    else if (scheme != null) {
        // handle non-file sources
        nativeSetDataSource(
            MediaHTTPService.createHttpServiceBinderIfNecessary(path),
            path,
            keys,
            values);
        return;
    }
    /* snip */