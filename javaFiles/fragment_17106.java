@Override
public void setUserVisibleHint(boolean isVisibleToUser) {
    try {
        if (isVisibleToUser) {
            final TextView modeselect = (TextView) view.findViewById(R.id.pass);

final SharedPreferences sharedPref = this.getActivity().getSharedPreferences("Mode", Activity.MODE_PRIVATE);
String get = sharedPref.getString("userChoicemode",selected);

modeselect.setText("" + get);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    super.setUserVisibleHint(isVisibleToUser);
}