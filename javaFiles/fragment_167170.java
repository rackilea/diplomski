@Transactional
public <S extends T> List<S> save(Iterable<S> entities) {

    List<S> result = new ArrayList<S>();

    if (entities == null) {
        return result;
    }

    for (S entity : entities) {
        result.add(save(entity));
    }

    return result;
}