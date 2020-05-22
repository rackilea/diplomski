List<Column> domoColumns = new ArrayList<Column>();
            for(Field field:o.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                String name = field.getName();
                domoColumns.add(new Column(ColumnType.STRING,name));
            }
return domoColumns;