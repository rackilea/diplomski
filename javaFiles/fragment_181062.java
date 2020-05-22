@Override
    public void communicate(ArrayList<ArrayList<Integer>> data) {
        for(int i = 0; i < numPlayer; i++) {
            if(viewPager.getCurrentItem() == i) {
                oneGame.set(i, data);
            }
        }
    }