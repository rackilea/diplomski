public class MyXAxisValueFormatter implements IAxisValueFormatter {
private List labels;

public MyXAxisValueFormatter(List<String> labels) {
    this.labels = labels;
}

@Override
public String getFormattedValue(float value, AxisBase axis) {
    try {
        int index = (int) value;
        return labels.get(index);
    } catch (Exception e) {
        return "";
    }
}
}