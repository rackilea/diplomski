@Override
public boolean onQueryTextChange(String newText) {
    String text = newText;
    adapter.filter(text);
    if(TextUtils.isEmpty(text)){
        list.setVisibility(View.GONE);
    }
    else {
        list.setVisibility(View.VISIBLE);
    }
    return true;
}