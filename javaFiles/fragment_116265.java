final class DefaultBigqueryProvider implements BigqueryProvider {
    @Override
    public Bigquery provide(Object options) {
        return Transport.newBigQueryClient(options).build();
    }
}