enum ChartSubTypes{
    PercentArea, StackedArea, ChartSubType3;
}

enum ChartTypes{
    AreaChart(ChartSubTypes.PercentArea, ChartSubTypes.StackedArea), 
    CharType2(ChartSubTypes.PercentArea, ChartSubTypes.ChartSubType3);

    private List<ChartSubTypes> subTypes = new ArrayList<ChartSubTypes>();

    private ChartTypes(ChartSubTypes ...chartSubTypes){
        for(ChartSubTypes subType : chartSubTypes){
            subTypes.add(subType);
        }
    }

    public List<ChartSubTypes> getSubTypes(){
        return Collections.unmodifiableList(subTypes);
    }
   }