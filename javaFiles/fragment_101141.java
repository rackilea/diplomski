private MultipleResult<Float> reduce(ArrayList<Float> theInput,Integer n){

    ArrayList<Float> opens=new ArrayList<>();
    ArrayList<Float> highs=new ArrayList<>();
    ArrayList<Float> lows=new ArrayList<>();
    ArrayList<Float> closes=new ArrayList<>();

    Integer N = theInput.size();

    for (int i=0;i<n;i++){

        Integer nMin = Math.round((N/n)*i);
        Integer nMax = Math.round((N/n)*(i+1))-1;

        Float open=theInput.get(nMax);
        Float high=theInput.get(nMin);
        Float low=theInput.get(nMin);
        Float close=theInput.get(nMin);

        for(int j=nMin;j<=nMax;j++){
            if (theInput.get(j)>high){
                high=theInput.get(j);
            }
            if (theInput.get(j)<low){
                low=theInput.get(j);
            }
        }

        opens.add(i,open);
        highs.add(i,high);
        lows.add(i,low);
        closes.add(i,close);

    }

    return new MultipleResult<Float>(opens,highs,lows,closes);
}