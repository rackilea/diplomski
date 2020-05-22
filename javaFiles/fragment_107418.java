double sampleCount = numSamples;
// our values come in as value and numSamples but StatisticSet wants a sum
double sum = value * numSamples;
if (numSamples == 0) {
    // special case here, CloudWatch does not allow a 0 sample count so we have to
    // set it to be slightly more
    sampleCount = 0.000000001D;
    // but sum can be 0
}
StatisticSet statisticSet =
    new StatisticSet().withMinimum(min)
            .withMaximum(max)
            .withSampleCount(sampleCount)
            .withSum(sum);