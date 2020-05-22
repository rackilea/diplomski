import java.util.List;

public class AnyJsonObject {
    private List<Name> name;

    public List<Name> getName() {
        return name;
    }

    public void setName(List<Name> name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Name n : name) sb.append(n.toString());

        return sb.toString();
    }
}