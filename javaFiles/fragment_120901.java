private Array getHstoreArray(SQLStatement<?> q, Map<String, String>[] maps) {
            try {
                String[] hstores = new String[maps.length];
                for (int i = 0; i < maps.length; i++)
                    hstores[i] = HStoreConverter.toString(maps[i]);
                return q.getContext().getConnection().createArrayOf("hstore", hstores);
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        }