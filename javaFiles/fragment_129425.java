public interface FinancialChart extends IsWidget {
  void setTickerSymbol(String tickerSymbol);
}

class FinancialChartPresenter extends Composite implements FinancialChart {
  private final FinancialChartView view;      
  private final DataServiceAsync service;

  @Inject(FinancialChartView view, DataServiceAsync service) {
    this.view = view;
    this.service = service;
  }

  @Override public Widget asWidget() {
    return view.asWidget();
  }

  @Override public void setTickerSymbol(String tickerSymbol) {
    service.getData(tickerSymbol, new AsyncCallback<FinancialData>() {
      @Override public void onFailure(Throwable t) {
        // handle error
      }

      @Override public void onSuccess(FinancialData data) {
        SimpleData simpleData = // do some parsing with presentation-specific
          // logic, e.g. make dramatic increases or decreases in price have a
          // a different color so they stand out.  End up with something simple
          // that's essentially some (x, y) points that the dumb view can plot
          // along with a label and color for each point.
        view.drawGraph(simpleData);
      }
  }
}

interface FinancialChartView extends IsWidget {
  void drawGraph(SimpleData simpleData);
}

class FinancialChartWidget extends Composite implements FinancialChartView {
  @Override public void drawGraph(SimpleData simpleData) {
    // plot the points on a chart.  set labels.  etc.
  }
}

class SomethingWithFinancialChartWidget extends Composite
    implements SomethingWithFinancialChart {
  interface Binder extends UiBinder<Widget, SomethingWithFinancialChartWidget> {}

  @UiField(provided = true) final FinancialChart chart;

  @Inject SomethingWithFinancialChartWidget(Binder binder, FinancialChart chart) {
    this.chart = chart;
    initWidget(binder.createAndBindUi(this));
  }
}

// In SomethingWithFinancialChartWidget.ui.xml
<ui:HTMLPanel>
  <!-- lots of stuff -->
  <mynamespace:FinancialChart ui:field="chart" />
  <!-- lots more stuff -->
</ui:HTMLPanel>

class MyPackagesGinModule extends AbstractGinModule {
  @Override protected void configure() {
    bind(FinancialChart.class).to(FinancialChartPresenter.class);
    bind(FinancialChartView.class).to(FinancialChartWidget.class);
  }
}