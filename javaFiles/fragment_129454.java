@Override
public void actionPerformed(final ActionEvent e) {
    final double factor = 0.9 + 0.2 * Math.random();
    lastValue = this.generateValue(lastValue, factor);
    series.add(new Millisecond(), lastValue);

    final double factor2 = 0.9 + 0.2 * Math.random();
    lastValue2 = this.generateValue(lastValue2, factor2);
    secondSeries.add(new Millisecond(), lastValue2);

    final double factor3 = 0.9 + 0.2 * Math.random();
    lastValue3 = this.generateValue(lastValue3, factor3);
    thirdSeries.add(new Millisecond(), lastValue3);
}