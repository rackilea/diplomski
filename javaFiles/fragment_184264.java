private MainActivity activity;
public void setup(MainActivity activity){ this.activity = activity;}

@Override
public void notifyDataSetChanged() {
    super.notifyDataSetChanged();
    if(activity != null){
        activity.getItems();
    }
}