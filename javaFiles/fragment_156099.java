if ("file".equals(scheme)) {
        path = uri.getPath();
    } else if (scheme != null) {
        // handle non-file sources
        nativeSetDataSource(
            MediaHTTPService.createHttpServiceBinderIfNecessary(path),
            path,
            keys,
            values);
        return;
    }