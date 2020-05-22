@Override
public void onDismiss(ListView listView, int[] reverseSortedPositions) {
    if(listView != null && reverseSortedPositions != null) {
       for (int position : reverseSortedPositions) {
          View child = listView.getChildAt(position);
          if(child != null) {
              TextView text = (TextView) child.findViewById(R.id.Details);
              String s = text.getText().toString();
              Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
          }
       }
    }
   inAdapter.notifyDataSetChanged();
}