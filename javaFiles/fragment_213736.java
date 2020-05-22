public static void main(String[] args) throws InterruptedException {
    List<Field> originalList = new ArrayList<Field>();
    originalList.add(new Field("field_38637"));
    originalList.add(new Field("field_38469"));
    originalList.add(new Field("field_38468"));
    originalList.add(new Field("field_38638"));
    originalList.add(new Field("field_38637"));
    originalList.add(new Field("field_38469"));
    originalList.add(new Field("field_38468"));
    originalList.add(new Field("field_38468"));
    originalList.add(new Field("field_38469"));
    originalList.add(new Field("field_38468"));
    originalList.add(new Field("field_38637"));

    System.out.println(originalList);
    List<Field> groupedList = new ArrayList<Field>(originalList.size());
    while (!originalList.isEmpty()) {
        String id = originalList.get(0).getFieldID();
        for (Iterator<Field> it = originalList.iterator(); it.hasNext();) {
            Field f = it.next();
            if (f.getFieldID().equals(id)) {
                it.remove();
                groupedList.add(f);
            }
        }
    }

    System.out.println(groupedList);
}

public static class Field {

    private final String fieldID;

    public Field(String fieldID) {
        this.fieldID = fieldID;
    }

    public String getFieldID() {
        return fieldID;
    }

    @Override
    public String toString() {
        return "Field{" + "fieldID=" + fieldID + '}';
    }
}