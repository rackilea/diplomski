public class UserAdapter extends BaseAdapter {
    private final List<User> mUsers;
    private final LayoutInflater mInflater;

    public UserAdapter(Context ctx, Collection<User> users) {
        mUsers = new ArrayList<User>();
        mInflater = LayoutInflater.from(ctx);
        if (users != null) {
            mUsers.addAll(users);
        }
    }

    @Override
    public int getCount() {
        // Just return the number of users in your data set
        return mUsers.size();
    }

    @Override
    public long getItemId(int pos) {
        // Mostly irrelevant if you're not using Cursors
        return pos;
    }

    @Override
    public User getItem(int pos) {
        // Just return the item at the specified position
        return mUsers.get(pos);
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        UserViewHolder uvh;

        if (convertView == null) {
            // Only inflate the layout if there's not already a recycled view
            convertView = mInflater.inflate(R.layout.single_user, parent, false);

            // Tag the view with a class holding the views found with 
            // findViewById() to prevent lookups later
            uvh = new UserViewHolder(convertView);
            convertView.setTag(uvh);
        } else {
            // If the view is non-null, then you will have already
            // created the view holder and set it as a tag
            uvh = (UserViewHolder) convertView.getTag();
        }

        // Now just get the user at the specified position and
        // set up the view as necessary
        User user = getItem(pos);
        uvh.usernameTxt.setText(user.getUsername());

        return convertView;
    }

    public static class UserViewHolder {
        public final TextView usernameTxt;

        public UserViewHolder(View v) {
            usernameTxt = (TextView) v.findViewById(R.id.textViewUsername);
        }
    }
}