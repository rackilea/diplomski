@Override
public String toString() {
    for(Field field : this.getClass().getFields()) {
        System.out.println(field.getName() + ":" + field.get(this) + ",");
    }
}