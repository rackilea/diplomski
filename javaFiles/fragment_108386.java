public static <T> List<T> getEntityList(Dao<T, Integer> dao) throws SQLException {
    ArrayList<T> list = new ArrayList<>();
    CloseableIterator<T> iterator = dao.closeableIterator();
    try {
        while (iterator.hasNext()){
            T item = iterator.next();
            list.add(item);
        }
    } finally {
        iterator.close();
    }

    return list;
}