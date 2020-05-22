public class FileMakerDialect extends Dialect {

...

    private static final LimitHandler LIMIT_HANDLER = new AbstractLimitHandler() {
        public String processSql(String sql, RowSelection selection) {
            String soff = String.format(" offset %d rows /*?*/", selection.getFirstRow());
            String slim = String.format(" fetch first %d rows only /*?*/", selection.getMaxRows());
            StringBuilder sb = (new StringBuilder(sql.length() + soff.length() + slim.length())).append(sql);

            if (LimitHelper.hasFirstRow(selection)) {
                sb.append(soff);
            }

            if (LimitHelper.hasMaxRows(selection)) {
                sb.append(slim);
            }

            return sb.toString();
        }

        public boolean supportsLimit() {
            return true;
        }
    };

...
}