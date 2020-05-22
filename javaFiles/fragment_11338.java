@Override
public int getItemCount() {
    return mItems.size();
}

public void updateAnswers(CountryResponse countryRes) {
    countyResponse = countryRes;
    notifyDataSetChanged();
}