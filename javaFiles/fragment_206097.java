case R.id.items_button_grid:
    if (lv.getVisibility() == View.VISIBLE) {
        lv.invalidate();
        lv.setAdapter(null);
        lv.setVisibility(View.GONE);
        mAdapter.setIsListView(false);
        mAdapter.notifyDataSetChanged();
        gv.setVisibility(View.VISIBLE);
        gv.setAdapter(mAdapter);
    }
    break;
case R.id.items_button_list:
    if (gv.getVisibility() == View.VISIBLE) {
        gv.invalidate();
        gv.setAdapter(null);
        gv.setVisibility(View.GONE);
        mAdapter.setIsListView(true);
        mAdapter.notifyDataSetChanged();
        lv.setVisibility(View.VISIBLE);
        lv.setAdapter(mAdapter);
    }
    break;