import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.CellTable.Resources;
import com.google.gwt.user.cellview.client.CellTable.Style;

public class MyResources implements Resources {

    public static final MyResources INSTANCE = new MyResources();

    @Override public ImageResource cellTableFooterBackground() {

        return MyImageResource.INSTANCE;
    }

    @Override public ImageResource cellTableHeaderBackground() {

        return MyImageResource.INSTANCE;
    }

    @Override public ImageResource cellTableLoading() {

        return MyImageResource.INSTANCE;
    }

    @Override public ImageResource cellTableSelectedBackground() {

        return MyImageResource.INSTANCE;
    }

    @Override public ImageResource cellTableSortAscending() {

        return MyImageResource.INSTANCE;
    }

    @Override public ImageResource cellTableSortDescending() {

        return MyImageResource.INSTANCE;
    }

    @Override public Style cellTableStyle() {

        return MyStyle.INSTANCE;
    }
}