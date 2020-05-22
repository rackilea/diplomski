public class MySQL55Dialect extends MySQL5Dialect {

        @Override
        protected MySQLStorageEngine getDefaultMySQLStorageEngine() {
                return InnoDBStorageEngine.INSTANCE;
        }
}