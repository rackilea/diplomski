public void calculate() {
    ...
    mChart.setCenterText("BMI:"+df.format(bmi));
    mChart.highlightValue(categoryIndex, 0, false);
    mChart.invalidate();
}