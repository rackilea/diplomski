void setUpCityList(int iCity) {
    int length = cities.length;   

    tvOneCity.setText(cities[iCity % length]);
    tvTwoCity.setText(cities[(iCity + 1) % length]);
    tvThreeCity.setText(cities[(iCity + 2) % length]);
}