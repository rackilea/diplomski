public String toString() {
        @SuppressWarnings("StringEquality")
        boolean cached = cachedString != NOT_CACHED;
        if (cached) {
            return cachedString;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(scheme).append(':');
        sb.append(getEncodedSchemeSpecificPart());
        if (!fragment.isEmpty()) {
            sb.append('#').append(fragment.getEncoded());
        }
        return cachedString = sb.toString();
    }