public final class CustomMap<K, V> extends HashMap<K, V> {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1493227382148892732L;

    @Override
    public String toString() {
        final Iterator<Map.Entry<K, V>> entryIterator = entrySet().iterator();

        if (!entryIterator.hasNext()) {
            return "";
        }

        final StringBuilder builder = new StringBuilder();

        for (;;) {
            final Map.Entry<K, V> entry = entryIterator.next();

            builder.append(entry.getKey());
            builder.append(" = ");
            builder.append(entry.getValue());

            if (!entryIterator.hasNext()) {
                return builder.toString();
            }

            builder.append(", ");
        }
    }

}