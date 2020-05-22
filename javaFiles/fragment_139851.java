@Override
public void add(DailyData newDailyData) {
    dailyDatas.add(newDailyData);
    notifyDataSetChanged();
}

@Override
public void addAll(Collection<? extends DailyData> newDailyDatas) {
    dailyDatas.addAll(newDailyDatas);
    notifyDataSetChanged();
}

@Override
public void insert(DailyData newDailyData, int index) {
    dailyDatas.add(index, newDailyData);
    notifyDataSetChanged();
}

@Override
public void remove(DailyData newDailyData) {
    dailyDatas.remove(newDailyData);
    notifyDataSetChanged();
}

@Override
public void clear() {
    dailyDatas.clear();
    notifyDataSetChanged();
}