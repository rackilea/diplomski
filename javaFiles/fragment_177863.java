Map<Record, Result<Record>> result = 
    dsl.selectFrom(...).fetch().intoGroups(CHEST.fields());

List<Chest> list = new ArrayList<>();
for (Entry<Record, Result<Record>> entry : result.entrySet()) {
    Record chest = entry.getKey();
    Result<Record> drawers = entry.getValue();

    list.add(new Chest(
        chest.into(Id.class),      // These into(Class<?>) methods assume that you
        drawers.into(Drawer.class) // want to use jOOQ's DefaultRecordMapper
    ));
}