public List<NamesForGroups> namesForGroups(SQLiteDatabase db) {
    List<NamesForGroups> namesForGroupsList= new ArrayList<>();
    SQLDelightStatement query = FACTORY.name_for_groups();
    Cursor cursor = db.rawQuery(query.statement, query.args);
        while (cursor.moveToNext() && NAMES_FOR_GROUPS_MAPPER.map(cursor) != null) {
            //NamesForGroups namesForGroups = NAMES_FOR_GROUPS_MAPPER.map(cursor);
            namesForGroupsList.add(NAMES_FOR_GROUPS_MAPPER.map(cursor));
        }

    return namesForGroupsList;
}