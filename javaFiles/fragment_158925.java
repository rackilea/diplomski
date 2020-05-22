static interface ColumnSource<T> {
    String getColumn(T value, int index);
}
static Map<Class, ColumnSource> map = new HashMap();
static {
    map.put(User.class, new UserNameAndRoleSource<User>() {
        public String getColumn(User user, int index) { 
            switch (index) {
                case 0: return user.getUserName(); 
                case 1: return user.getUserRole(); 
                default: throw new RuntimeException();
            }
        }
    });
    map.put(Run.class, new ColumnSource<Run>() {
        public String getColumn(Run run, int index) { 
            switch (index) {
                case 0: return run.getRunName(); 
                case 1: return run.getRunNumer();
                default: throw new RuntimeException();
            }
        }
    });
}
public static Object getValueAt(int rowIndex, int columnIndex, Object o) {
   Class type = o.getClass();
   ColumnSource source = map.get(type);
   if (source == null) throw new RuntimeException(type.getName() + " not supported"); 
   return source.getColumn(o, columnIndex);
}