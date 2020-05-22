if (null != b) {
    arr = b.getStringArrayList("list");
    int index = 0;
    Timer t = new Timer();
    t.scheduleAtFixedRate(new TimerTask(){
        @Override
        public void run(){
           tv.setText(arr.get(index));
           if(index == (arr.size() - 1)){
               t.cancel();
           }else{
               index++;
           }

        }
    },0,3000);
}
else {
    Toast.makeText(this, "Sorryy", Toast.LENGTH_SHORT).show();
}