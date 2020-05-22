private View initialize(Context context) {
    LayoutInflater inflater = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View v = inflater.inflate(R.layout.view_mypage_after_login, null);

    mBtnLogout = (Button) v.findViewById(R.id.logout);
    return v;
}