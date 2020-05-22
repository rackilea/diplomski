import java.util.ArrayList;
import java.util.List;

public class Decode {

private String label;
private List<String> values = new ArrayList<>(); // in json it is "value"

public String getLabel() {
    return label;
}

public void setLabel(String label) {
    this.label = label;
}

public List<String> getValues() {
    return values;
 }

public void setValues(List<String> values) {
    this.values = values;
 }

@Override
public String toString() {
    return "Decode [label=" + label + ", values=" + values + "]";
 }

}