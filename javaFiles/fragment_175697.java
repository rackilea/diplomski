package com.tutorialz.paul.scaleplotdesign;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

import com.androidplot.Plot;
import com.androidplot.ui.SizeLayoutType;
import com.androidplot.ui.SizeMetrics;
import com.androidplot.xy.BoundaryMode;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;

public class MainActivity extends Activity implements OnTouchListener {
    private static final int SERIES_SIZE = 200;
    private XYPlot plotOne, plotTwo;
    private SimpleXYSeries series1 = null;
    private SimpleXYSeries series2 = null;
    private PointF minXY;
    private PointF maxXY;
    float zoomRatio = 2, leftBoundary, rightBoundary;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //plot setup
        plotOne = (XYPlot) findViewById(R.id.myFirstXYPlot);
        plotOne.setOnTouchListener(this);
        plotOne.getGraphWidget().setTicksPerRangeLabel(2);
        plotOne.getGraphWidget().setTicksPerDomainLabel(2);
        plotOne.getGraphWidget().setRangeLabelWidth(25);
        plotOne.setRangeLabel("");
        plotOne.setDomainLabel("");
        plotOne.setBorderStyle(Plot.BorderStyle.NONE, null, null);
        plotOne.getLayoutManager().remove(plotOne.getLegendWidget());
        plotOne.getGraphWidget().setSize(new SizeMetrics(0,SizeLayoutType.FILL,
                0, SizeLayoutType.FILL));
        plotOne.setPlotMargins(0,0,0,0);

        plotTwo = (XYPlot) findViewById(R.id.mySecondXYPlot);
        plotTwo.setOnTouchListener(this);
        plotTwo.getGraphWidget().setTicksPerRangeLabel(2);
        plotTwo.getGraphWidget().setTicksPerDomainLabel(2);
        plotTwo.getGraphWidget().setRangeLabelWidth(25);
        plotTwo.setRangeLabel("");
        plotTwo.setDomainLabel("");
        plotTwo.setBorderStyle(Plot.BorderStyle.NONE, null, null);
        plotTwo.getLayoutManager().remove(plotTwo.getLegendWidget());
        plotTwo.getGraphWidget().setSize(new SizeMetrics(0,SizeLayoutType.FILL,
                0, SizeLayoutType.FILL));
        plotTwo.setPlotMargins(0,0,0,0);
        //********
        //series setup
        series1 = new SimpleXYSeries("PARAM");
        populateSeries(series1, 25);
        //series1.setModel(values1, SimpleXYSeries.ArrayFormat.Y_VALS_ONLY);
        series1.useImplicitXVals();
        LineAndPointFormatter line1 = new LineAndPointFormatter();
        line1.setPointLabelFormatter(new PointLabelFormatter());
        line1.configure(getApplicationContext(), R.xml.f1);

        series2 = new SimpleXYSeries("PARAM");
        populateSeries(series2, 15);
        //series2.setModel(values1, SimpleXYSeries.ArrayFormat.Y_VALS_ONLY);
        series2.useImplicitXVals();
        LineAndPointFormatter line2 = new LineAndPointFormatter();
        line2.setPointLabelFormatter(new PointLabelFormatter());
        line2.configure(getApplicationContext(), R.xml.f2);

        plotOne.addSeries(series1, line1);
        plotTwo.addSeries(series2, line2);

        plotOne.redraw();
        plotTwo.redraw();

        plotOne.calculateMinMaxVals();
        minXY = new PointF(plotOne.getCalculatedMinX().floatValue(),
                plotOne.getCalculatedMinY().floatValue());
        maxXY = new PointF(plotOne.getCalculatedMaxX().floatValue(),
                plotOne.getCalculatedMaxY().floatValue());

        leftBoundary = series1.getX(0).floatValue();
        rightBoundary = series1.getX(series1.size() - 1).floatValue();
    }

    private void populateSeries(SimpleXYSeries series, int max) {
        Random r = new Random();
        for(int i = 0; i < SERIES_SIZE; i++) {
            series.addLast(i, r.nextInt(max));
        }
    }
    //*****************
    // Definition of the touch states
    static final int NONE = 0;
    static final int ONE_FINGER_DRAG = 1;
    static final int TWO_FINGERS_DRAG = 2;
    int mode = NONE;

    PointF firstFinger;
    float distBetweenFingers;
    boolean stopThread = false;

    @Override
    public boolean onTouch(View arg0, MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN: // Start gesture
                firstFinger = new PointF(event.getX(), event.getY());
                mode = ONE_FINGER_DRAG;
                stopThread = true;
                break;
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_UP:
                mode = NONE;
                break;
            case MotionEvent.ACTION_POINTER_DOWN: // second finger
                distBetweenFingers = spacing(event);
                // the distance check is done to avoid false alarms
                if (distBetweenFingers > 5f) {
                    mode = TWO_FINGERS_DRAG;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (mode == ONE_FINGER_DRAG) {
                    PointF oldFirstFinger = firstFinger;
                    firstFinger = new PointF(event.getX(), event.getY());
                    scroll(oldFirstFinger.x - firstFinger.x);
                    plotOne.setDomainBoundaries(minXY.x, maxXY.x,
                            BoundaryMode.FIXED);
                    plotOne.redraw();
                    plotTwo.setDomainBoundaries(minXY.x, maxXY.x,
                            BoundaryMode.FIXED);
                    plotTwo.redraw();

                } else if (mode == TWO_FINGERS_DRAG) {
                    float oldDist = distBetweenFingers;
                    distBetweenFingers = spacing(event);
                    zoom(oldDist / distBetweenFingers);
                    plotOne.setDomainBoundaries(minXY.x, maxXY.x,
                            BoundaryMode.FIXED);
                    plotOne.redraw();
                    plotTwo.setDomainBoundaries(minXY.x, maxXY.x,
                            BoundaryMode.FIXED);
                    plotTwo.redraw();
                }
                break;
        }
        return true;
    }

    private void zoom(float scale) {
        float domainSpan = maxXY.x - minXY.x;
        float oldMax = maxXY.x;
        float oldMin = minXY.x;
        float domainMidPoint = maxXY.x - (domainSpan / 2.0f);
        float offset = domainSpan * scale / 2.0f;
        minXY.x = domainMidPoint - offset;
        maxXY.x = domainMidPoint + offset;
        float newSpan = maxXY.x - minXY.x;
        if (newSpan < (float)5) {
            minXY.x = oldMin;
            maxXY.x = oldMax;
        }

        if (minXY.x < leftBoundary) {
            minXY.x = leftBoundary;
            maxXY.x = leftBoundary + domainSpan * zoomRatio;
            if (maxXY.x > series1.getX(series1.size() - 1).floatValue())
                maxXY.x = rightBoundary;
        }
        if (maxXY.x > series1.getX(series1.size() - 1).floatValue()) {
            maxXY.x = rightBoundary;
            minXY.x = rightBoundary - domainSpan * zoomRatio;
            if (minXY.x < leftBoundary) minXY.x = leftBoundary;
        }
    }

    private void scroll(float pan) {
        float domainSpan = maxXY.x - minXY.x;
        float step = domainSpan / plotOne.getWidth();
        float offset = pan * step;
        minXY.x = minXY.x + offset;
        maxXY.x = maxXY.x + offset;

        if (minXY.x < leftBoundary) {
            minXY.x = leftBoundary;
            maxXY.x = leftBoundary + domainSpan;
        }
        if (maxXY.x > series1.getX(series1.size() - 1).floatValue()) {
            maxXY.x = rightBoundary;
            minXY.x = rightBoundary - domainSpan;
        }
    }

    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return FloatMath.sqrt(x * x + y * y);
    }
}