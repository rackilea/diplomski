public class TreeItemTypeAdapter<T> extends TypeAdapter<TreeItem<T>> {

    private Gson gson;

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    private final Class<T> valueClass;

    public TreeItemTypeAdapter(Class<T> valueClass) {
        if (valueClass == null) {
            throw new IllegalArgumentException();
        }
        this.valueClass = valueClass;
    }

    public static TreeItemTypeAdapter<String> createStringTreeItemAdapter() {
        return new TreeItemTypeAdapter<>(String.class);
    }

    private void writeValue(JsonWriter writer, T t) throws IOException {
        if (gson == null) {
            writer.value(Objects.toString(t, null));
        } else {
            gson.toJson(t, valueClass, writer);
        }
    }

    private T readValue(JsonReader reader) throws IOException {
        if (gson == null) {
            Object value = reader.nextString();
            return (T) value;
        } else {
            return gson.fromJson(reader, valueClass);
        }
    }

    @Override
    public void write(JsonWriter writer, TreeItem<T> t) throws IOException {
        writer.beginObject().name("value");
        writeValue(writer, t.getValue());
        writer.name("children").beginArray();
        LinkedList<Iterator<TreeItem<T>>> iterators = new LinkedList<>();
        iterators.add(t.getChildren().iterator());
        while (!iterators.isEmpty()) {
            Iterator<TreeItem<T>> last = iterators.peekLast();
            if (last.hasNext()) {
                TreeItem<T> ti = last.next();
                writer.beginObject().name("value");
                writeValue(writer, ti.getValue());
                writer.name("children").beginArray();
                iterators.add(ti.getChildren().iterator());
            } else {
                writer.endArray().endObject();
                iterators.pollLast();
            }
        }
    }

    @Override
    public TreeItem<T> read(JsonReader reader) throws IOException {
        if (gson == null && !valueClass.getName().equals("java.lang.String")) {
            throw new IllegalStateException("cannot parse classes other than String without gson provided");
        }
        reader.beginObject();
        if (!"value".equals(reader.nextName())) {
            throw new IOException("value expected");
        }
        TreeItem<T> root = new TreeItem<>(readValue(reader));
        TreeItem<T> item = root;
        if (!"children".equals(reader.nextName())) {
            throw new IOException("children expected");
        }
        reader.beginArray();
        int depth = 1;
        while (depth > 0) {
            if (reader.hasNext()) {
                reader.beginObject();
                if (!"value".equals(reader.nextName())) {
                    throw new IOException("value expected");
                }
                TreeItem<T> newItem = new TreeItem<>(readValue(reader));
                item.getChildren().add(newItem);
                item = newItem;
                if (!"children".equals(reader.nextName())) {
                    throw new IOException("children expected");
                }
                reader.beginArray();
                depth++;
            } else {
                depth--;
                reader.endArray();
                reader.endObject();
                item = item.getParent();
            }

        }
        return root;
    }

}