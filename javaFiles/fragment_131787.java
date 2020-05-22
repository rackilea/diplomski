public class MyCachedCqlTemplate extends CqlTemplate {

    PreparedStatementCache cache = MapPreparedStatementCache.create();

    @Override
    protected PreparedStatementCreator newPreparedStatementCreator(String cql) {
        return CachedPreparedStatementCreator.of(cache, cql);
    }

}