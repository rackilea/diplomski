class Query<T> extends SQLiteJob<T> {
    protected T job(SQLiteConnection connection)
            throws SQLiteException{
            return ...; // Return something of type T
    }
}