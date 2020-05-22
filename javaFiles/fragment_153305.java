import javax.persistence.Table;

.....

Class<?> c = User.class;
Table table = c.getAnnotation(Table.class);
String tableName = table.name();