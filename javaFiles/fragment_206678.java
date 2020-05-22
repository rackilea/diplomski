@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity= activity;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // this is where i call the method for showing the twolinearlayout again  
          ((MainActivity) mainActivity).showTwoLinearLayout();
          ((MainActivity) mainActivity).hideCategoryContainerLayout();
    }