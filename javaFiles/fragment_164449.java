import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.text.shared.AbstractSafeHtmlRenderer;
import com.google.gwt.text.shared.SafeHtmlRenderer;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;

public class MyGrid extends DataGrid<MyPojo> {

    private List<MyPojo> allRows = new ArrayList<>();

    private final Set<MyPojo> openedRows = new HashSet<MyPojo>();

    public MyGrid() {
        TextColumn<MyPojo> column1 = new TextColumn<MyPojo>() {

            @Override
            public String getValue(MyPojo object) {
                return object.getValue1();
            }
        };
        addColumn(column1, "Column1");

        SafeHtmlRenderer<String> anchorRenderer = new AbstractSafeHtmlRenderer<String>() {
            @Override
            public SafeHtml render(final String object) {

                if (!object.isEmpty()) {

                    SafeHtmlBuilder sb = new SafeHtmlBuilder();
                    sb.appendHtmlConstant("<a href=\"javascript:;\">").appendEscaped(object)
                            .appendHtmlConstant("</a>");
                    return sb.toSafeHtml();
                }
                return null;

            }
        };

        Column<MyPojo, String> openRowColumn = new Column<MyPojo, String>(
                new ClickableTextCell(anchorRenderer)) {

            public String getValue(final MyPojo object) {

                if (object.getChildren() != null && object.getChildren().size() != 0) {

                    if (openedRows.contains(object)) {
                        return "Hide";
                    }
                    return "Open";
                } else {
                    return null;
                }

            }

        };
        addColumn(openRowColumn, "Open Column");

        openRowColumn.setFieldUpdater(new FieldUpdater<MyPojo, String>() {

            @Override
            public void update(final int index, final MyPojo object, final String value) {
                handleChild(index, object);

            }

        });

        addContent();

    }

    private void handleChild(int index, MyPojo object) {
        List<MyPojo> children = object.getChildren();

        if (children != null && children.size() != 0 && !openedRows.contains(object)) {
            allRows.addAll(index + 1, children);
            openedRows.add(object);
            setRowData(allRows);
        } else if (openedRows.contains(object)) {

            for (int i = 0; i < children.size(); i++) {
                allRows.remove(index + 1);
            }
            openedRows.remove(object);
            setRowData(allRows);

        }

    }

    private void addContent() {

        MyPojo child = new MyPojo("Child 1", null);
        List<MyPojo> children = new ArrayList<>();
        children.add(child);

        for (int i = 0; i < 5; i++) {
            allRows.add(new MyPojo("c" + i, children));
        }
        setRowData(allRows);
    }
}