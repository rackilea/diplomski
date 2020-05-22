package com.mySampleApplication.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import org.moxieapps.gwt.highcharts.client.*;

import org.moxieapps.gwt.highcharts.client.labels.DataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.LinePlotOptions;

public class MyChart extends Composite {


    interface MyUiBinder extends UiBinder<FlowPanel, MyChart> {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    @UiField(provided = true)
    public final Chart chart;

    public MyChart() {
        chart = new Chart()
                .setType(Series.Type.LINE)
                .setChartTitle(new ChartTitle().setText("Monthly Average Temperature"))
                .setChartSubtitle(new ChartSubtitle().setText("Source: WorldClimate.com"))
                .setToolTip(new ToolTip().setEnabled(false));

        chart.getXAxis()
                .setCategories(
                        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
                );

        chart.getYAxis().setAxisTitleText("Temperature Â°C");

        chart.setLinePlotOptions(new LinePlotOptions()
                        .setEnableMouseTracking(true)
                        .setDataLabels(new DataLabels()
                                        .setEnabled(true)
                        )
        );

        chart.addSeries(chart.createSeries()
                        .setName("Tokyo")
                        .setPoints(new Number[]{
                                7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6
                        })
        );
        chart.addSeries(chart.createSeries()
                        .setName("London")
                        .setPoints(new Number[]{
                                3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8
                        })
        );

        initWidget(uiBinder.createAndBindUi(this));
    }
}