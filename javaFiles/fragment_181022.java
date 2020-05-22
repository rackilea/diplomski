public class Group {
    private final Set<String> fields = new HashSet<>();
    private final Set<String> methods = new HashSet<>();

    public Group addFields(String...fields) {
        for (String field: fields) {
            this.fields.add(field);
        }
        return this;
    }

    public Group addMethods(String... methods) {
        for (String method: methods) {
            this.methods.add(method);
        }
        return this;
    }

    public int fields() {
        return fields.size();
    }

    public int methods() {
        return methods.size();
    }

    public boolean intersects(Group other) {
        for (String field: other.fields) {
            if (fields.contains(field)) {
                return true;
            }
        }
        for (String method: other.methods) {
            if (methods.contains(method)) {
                return true;
            }
        }
        return false;
    }

    public void merge(Group other) {
        fields.addAll(other.fields);
        methods.addAll(other.methods);
    }

    @Override
    public String toString() {
        return "Group{" + "fields=" + fields + ", methods=" + methods + '}';
    }
}