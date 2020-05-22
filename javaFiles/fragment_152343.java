public void getReward(){
    if(count == 3) {
        Intent intent = new Intent(getApplicationContext(), com.creatives.arfa.revealthesecretsgame.Reward.class);
        intent.putExtra("activity", "level1");
        startActivity(intent);

    }
}