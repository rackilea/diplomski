table_1.addGeneratedColumn("mycolumn", new ColumnGenerator() {
        public Object generateCell(Table source, Object itemId, Object columnId) {
            Item item = source.getItem(itemId);
            String admin = (String) item.getItemProperty("admin").getValue();
            return admin.equals("Y") ? "true" : "false";

        }
    });