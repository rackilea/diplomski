@NamedNativeQueries( {
        @NamedNativeQuery(name = "findCalendarsCoreInfoById",
                query = "SELECT c.id, c.email, c.original_id, c.read_only, c.deleted" +
                        " FROM {h-schema}calendar c" +
                        " JOIN {h-schema}account_calendar_relation atr ON atr.calendar_id = c.id" +
                        " JOIN {h-schema}account_table a ON a.id = atr.account_id" +
                        " WHERE a.user_id = ? ",
                resultSetMapping = "calendarsCoreInfoMapping"
        ),
})