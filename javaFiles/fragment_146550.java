DocumentRow row = new DocumentRow();
row.setValue(Column.TEXT_VALUE, new DocumentCell<>("asdf"));
row.setValue(Column.NUMERIC_VALUE, new DocumentCell<>(4));
row.setValue(Column.DATE_VALUE, new DocumentCell<>(new Date()));

String s = row.getValue(Column.TEXT_VALUE);
Number i = row.getValue(Column.NUMERIC_VALUE);
Date d = row.getValue(Column.DATE_VALUE);