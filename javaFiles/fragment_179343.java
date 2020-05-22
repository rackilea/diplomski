@SqlUpdate("insert ...")
public abstract void insert(...);

@SqlUpdate("update...")
public abstract void update();

public X createOrUpdate(final X x) {
    if (!exists(x)) {
        insert(x);
    } else {
        update(x);
    }
    return find(...);
}