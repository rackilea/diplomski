import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.data.provider.Query;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.FooterRow;
import com.vaadin.ui.components.grid.HeaderRow;
import com.vaadin.ui.themes.ValoTheme;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilteredGrid extends VerticalLayout {
    public FilteredGrid() {
        // list data provider with some random data
        Random random = new Random();
        List<Quote> quotes = IntStream.range(1, 11).mapToObj(month -> new Quote(month, random.nextInt(10))).collect(Collectors.toList());
        ListDataProvider<Quote> provider = new ListDataProvider<>(quotes);

        // month number filter combo
        ComboBox<Integer> monthFilterCombo = new ComboBox<>("Starting with", IntStream.range(1, 10).boxed().collect(Collectors.toList()));
        monthFilterCombo.setEmptySelectionCaption("All");
        monthFilterCombo.addStyleName(ValoTheme.COMBOBOX_SMALL);
        monthFilterCombo.addValueChangeListener(event -> {
            if (event.getValue() == null) {
                provider.clearFilters();
            } else {
                provider.setFilter(quote -> quote.getMonth() > event.getValue());
            }
        });

        // grid setup
        Grid<Quote> grid = new Grid<>(Quote.class);
        grid.setDataProvider(provider);

        // header and footer
        HeaderRow header = grid.appendHeaderRow();
        header.getCell("month").setComponent(monthFilterCombo);
        FooterRow footer = grid.prependFooterRow();
        footer.getCell("month").setHtml("<b>Total:</b>");
        provider.addDataProviderListener(event -> footer.getCell("value").setHtml(calculateTotal(provider)));

        // add grid to UI
        setSizeFull();
        grid.setSizeFull();
        addComponent(grid);

        // trigger initial calculation
        provider.refreshAll();
    }

    // calculate the total of the filtered data
    private String calculateTotal(ListDataProvider<Quote> provider) {
        return "<b>" + String.valueOf(provider.fetch(new Query<>()).mapToInt(Quote::getValue).sum()) + "</b>";
    }

    // basic bean for easy binding
    public class Quote {
        private int month;
        private int value;

        public Quote(int month, int value) {
            this.month = month;
            this.value = value;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}