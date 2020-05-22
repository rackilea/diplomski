private List<Occurrence> mDataSet;
private Activity activity;

//Added here temporary ArrayList
private ArrayList<String> mSelectedPosition = new ArrayList<String>;

public <OccurrencesActivity extends OnOccurrenceSelectedListener> OccurrencesAdapter(OccurrencesActivity occurrencesActivity, List<Occurrence> occurrences) {
    this.activity = (android.app.Activity) occurrencesActivity;
    mDataSet = occurrences;
}

@Override
public void onBindViewHolder(final ViewHolder holder, final int position) {


    //Set ViewTag
    holder.itemView.setTag(position);

    //Check everyposition during view binding process
    if(mSelectedPosition.contains(String.valueOf(position))){

     holder.itemView.setBackgroundColor(App.getContext().getResources().getColor(R.color.white));
                holder.titleTextView.setTextColor(App.getContext().getResources().getColor(R.color.turquoise));
                holder.statusTextView.setTextColor(App.getContext().getResources().getColor(R.color.grey));
                holder.dateTextView.setTextColor(App.getContext().getResources().getColor(R.color.grey));
                holder.timeTextView.setTextColor(App.getContext().getResources().getColor(R.color.grey));


     }else{
    holder.itemView.setBackgroundColor(App.getContext().getResources().getColor(R.color.white));
                    holder.titleTextView.setTextColor(App.getContext().getResources().getColor(R.color.turquoise));
                    holder.statusTextView.setTextColor(App.getContext().getResources().getColor(R.color.grey));
                    holder.dateTextView.setTextColor(App.getContext().getResources().getColor(R.color.grey));
                    holder.timeTextView.setTextColor(App.getContext().getResources().getColor(R.color.grey));

      }

    Occurrence instance = mDataSet.get(position);
    ...
    setOnClickListener(holder, instance);
    }

private void setOnClickListener(final ViewHolder holder, final Occurrence occurrence) {
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

       // Get Position
         int position = (int) view.getTag();

            //Remove SelectedPosition if Already there
              if(mSelectedPosition.contains(position))
                  mSelectedPosition.remove(String.valueOf(position));
               else
                  mSelectedPosition.add(String.valueOf(position));

                notifyDataSetChanged();

               //Not sure about this lines 
                occurrence.setSelected(!occurrence.isSelected());

                ((OnOccurrenceSelectedListener)activity).onOccurrenceSelected(mDataSet);
            }
        });
    }