int totalTime = ....;
List<Integer> intervals = new ArrayList<Integer>();
intervals.add(0); // 0%
intervals.add((int)(totalTime * 0.20f)); // 20%
intervals.add((int)(totalTime * 0.40f)); // 40%
intervals.add((int)(totalTime * 0.60f)); // 60%
intervals.add((int)(totalTime * 0.80f)); // 80%;
intervals.add((int)(totalTime * 0.90f)); // 90%
intervals.add((int)(totalTime * 0.95f)); // 95%
intervals.add(totalTime); // 100%

Handler handler = new Handler();
Runnable run = new Runnable() {
    @Override
    public void run() {
        fliper.showNext(); 
    }
};

for(int interval:intervals){
    handler.postDelayed(run, interval);
}