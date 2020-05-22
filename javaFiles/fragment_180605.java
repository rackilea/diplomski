public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    List<LevelInfo> levelsInfo;

    public ImageAdapter(Context c, List<LevelInfo> levelsInfo) {
        mContext = c;
        this.levelsInfo = levelsInfo;
    }
    public int getCount() {
        return levelsInfo.size();
    }

    public View getView(final int position, View convertView, final ViewGroup parent) {

        ....

        LevelInfo currentLevel = levelsInfo.get(position);
        button.setText(currentLevel.title);
        button.setTextColor(Color.WHITE);
        if(currentLevel.locked){
            button.setBackgroundResource(R.drawable.wood);
        }else{
            button.setBackgroundResource(currentLevel.image); 
        }
        button.setId(position);

        return button;
    }

}