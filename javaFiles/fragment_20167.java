public class TimedEventsAdapter extends BaseAdapter {
    private static final int VIEW_TYPE_COUNT = 2;
    private static final int VIEW_TYPE_MESSAGE = 0;
    private static final int VIEW_TYPE_SOUND = 1;

    private final List<Object> mItems;
    private final LayoutInflater mInflater;

    public TimedEventsAdapter(Context context, List<Object> objects) {
        mInflater = LayoutInflater.from(context);

        // Ensure that mItems is never null, even if a null object list
        // is received.
        mItems = new ArrayList<>();
        if (objects != null) {
            mItems.addAll(objects);
        }
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        // Just return the item in the appropriate position in the list
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        // Arbitrary value here since there is no unique identifier for the data
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int viewType = getItemViewType(position);

        // Initialize the View based on the view type (provided by getItemViewType())
        // Set a tag with an appropriate ViewHolder type to avoid findViewById() calls
        // on every iteration.
        if (convertView == null) {
           if (VIEW_TYPE_SOUND == viewType) {
               convertView = mInflater.inflate(R.layout.complete_event_description, parent, false);
               convertView.setTag(new SoundViewHolder(convertView));
           } else if (VIEW_TYPE_MESSAGE == viewType) {
               convertView = mInflater.inflate(R.layout.message_list_view, parent, false);
               convertView.setTag(new MessageViewHolder(convertView));
           }
        }

        // Update the View based on the view type. You know that you will have a non-null
        // View and appropriate ViewHolder set as a tag since that's been confirmed above.
        if (VIEW_TYPE_SOUND == viewType) {
            SoundDetails device = (SoundDetails) getItem(position);
            SoundViewHolder holder = (SoundViewHolder) convertView.getTag();

            holder.eventName.setText(device.name);
            holder.eventTime.setText(device.time);
            holder.state.setChecked(device.isEventActive);
            holder.state.setTag(position);
        } else if (VIEW_TYPE_MESSAGE == viewType) {
            MessageListDetails details = (MessageListDetails) getItem(position);
            MessageViewHolder holder = (MessageViewHolder) convertView.getTag();

            holder.contactName.setText(details.contactName);
            holder.contactNumber.setText(details.contactNumber);
            holder.timeToSend.setText(details.sendingTime);
        }

        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        // Return the number of different view types to be eligible 
        // for View recycling.
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        // Figure out what type of data is at the given position.
        // instanceOf isn't very efficient -- it would be beter 
        // if the objects shared a base class that described what
        // they were, but for this example it will work.
        if (getItem(position) instanceof SoundDetails) {
            return VIEW_TYPE_SOUND;
        } else {
            return VIEW_TYPE_MESSAGE;
        }
    }

    //
    // Simple classes for holding references to views
    //

    private static class SoundViewHolder {
        final TextView eventName;
        final TextView eventTime;
        final Switch state;

        SoundViewHolder(View v) {
            eventName = (TextView) v.findViewById(R.id.event_name);
            eventTime = (TextView) v.findViewById(R.id.event_time);
            state = (Switch) v.findViewById(R.id.state);
        }
    }

    private static class MessageViewHolder {
        final TextView contactName;
        final TextView contactNumber;
        final TextView timeToSend;

        MessageViewHolder(View v) {
            contactName = (TextView) v.findViewById(R.id.contactName);
            contactNumber = (TextView) v.findViewById(R.id.contactNumber);
            timeToSend = (TextView) v.findViewById(R.id.timeToSend);
        }
    }
}