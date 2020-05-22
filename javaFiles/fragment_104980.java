public class ScoreListAdapter extends ArrayAdapter<Score> {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            final OnClickListener lsScoreView = new OnClickListener() {
                  @Override
                    public void onClick(View v) {
                       ScoreList.selectedPlayer;//You can use selectedPlayer here
                  }
            };

        }
    }