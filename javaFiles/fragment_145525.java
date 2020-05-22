public class Types {
    private Object type;

    //// getters and setters

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public List<Type> getListType() {
        if (type instanceof List) {
            return (List<Type>) type;
        } else
            return null;
    }

    public Type getObjectType() {
        if (type instanceof Type) {
            return (Type) type;
        } else if (type instanceof Map) {
            Map<String, String> map = (Map<String, String>)type;
            Type newType = new Type((String)map.get("typeId"), (String)map.get("typeName"));
            return newType;
        }
        return null;
    }

public class Type {
    private String typeId;
    private String typeName;

    public Type() {}

    public Type(String id, String name) {
        this.typeId = id;
        this.typeName = name;
    }

    //// getters and setters
    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}