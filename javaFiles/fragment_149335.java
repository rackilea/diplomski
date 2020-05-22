public class MovingAvgByDateFunction implements PairFunction<Object,Date,Double> {

/**
 * 
 */
private static final long serialVersionUID = 9220435667459839141L;

@Override
public Tuple2<Date, Double> call(Object t) throws Exception {

    StockQuotation[] stocks = (StockQuotation[]) t;
    List<StockQuotation> stockList = Arrays.asList(stocks);

    Double result = stockList.stream().collect(Collectors.summingDouble(new ToDoubleFunction<StockQuotation>() {

        @Override
        public double applyAsDouble(StockQuotation value) {
            return value.getValue();
        }
    }));

    result = result / stockList.size();

    return new Tuple2<Date, Double>(stockList.get(0).getTimestamp(),result);
}
}