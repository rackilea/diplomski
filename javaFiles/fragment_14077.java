@Override
    public Fragment getItem(int position) {
        int index = position % mFrags.size();
        return mFrags.get(index);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }