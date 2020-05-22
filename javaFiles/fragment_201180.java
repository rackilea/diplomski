abstract class Entities<E extends BaseEntity, I extends EntityIndex<E>> {
    public static final Entities<CoolEntity, CoolIndex> COOL_ENTITY = new Entities<CoolEntity, CoolIndex>() {
        @Override
        public Class<CoolIndex> getIndexCls() {
            return  CoolIndex.class;
        }

        @Override
        public Class<CoolEntity> getEntityCls() {
            return CoolEntity.class;
        }
    };

    // Don't instantiate outside this class!
    private Entities() {}

    public abstract Class<I> getIndexCls();
    public abstract Class<E> getEntityCls();
}