int filtered;
    View yourView;
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
                    yourList= (ArrayList<?>) results.values;
                    filtered = yourList.size();
                    yourView.post(new Runnable() {
                        @Override
                        public void run() {
                            yourView.setText("Total " + filtered);
                        }
                    });
                    notifyDataSetChanged();
                }