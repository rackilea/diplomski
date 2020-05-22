public class ChatAdapter extends BaseAdapter {

    int mColorResource;

    ChatAdapter(Activity activity, ArrayList<ChatData> list, int initialColorResource) {
        mContext = activity;
        chatMessageList = list;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // You must receive the color on the construtor
        mColorResource = initialColor;
    }

    // Use this method to update the color (when user select a new color)
    public void setColor(int newColorResource) {
        mColorResource = newColorResource;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ...
        // Note how this if-else is cleaner now
        if (message.isMine) {
            layout.setGravity(Gravity.RIGHT);
            msg.setBackgroundResource(mColorResource);
            parent_layout.setGravity(Gravity.RIGHT);
        } else {
            layout.setGravity(Gravity.LEFT);
            msg.setBackgroundResource(R.drawable.bot_chat);
            parent_layout.setGravity(Gravity.LEFT);
        }
        ...
    }
}