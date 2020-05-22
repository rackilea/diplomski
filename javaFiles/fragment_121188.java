public class RVAdapter extends RecyclerView.Adapter<RVAdapter.EventViewHolder> {

public static class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    CardView cv;
    TextView eventName;
    TextView eventTime;
    TextView eventLocation;
    ImageView orgPhoto;


    EventViewHolder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cv);
        eventName = (TextView) itemView.findViewById(R.id.event_name);
        eventTime = (TextView) itemView.findViewById(R.id.event_time);
        eventLocation = (TextView) itemView.findViewById(R.id.event_location);
        orgPhoto = (ImageView) itemView.findViewById(R.id.org_photo);
    }

    @Override
    public void onClick(View view) {
        //do stuff
    }
}

List<Event> events;

RVAdapter(List<Event> events){
    this.events = events;
}

@Override
public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
}

@Override
public EventViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_card, viewGroup, false);
    return new EventViewHolder(v);
}

@Override
public void onBindViewHolder(EventViewHolder EventViewHolder, final int i) {
    EventViewHolder.eventName.setText(events.get(i).name);
    EventViewHolder.eventTime.setText(events.get(i).time);
    EventViewHolder.eventLocation.setText(events.get(i).location);
    EventViewHolder.orgPhoto.setImageResource(events.get(i).orgPhoto);

}

@Override
public int getItemCount() {
    return events.size();
}
}