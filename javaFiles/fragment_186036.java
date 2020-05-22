@Override
public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(item.isEnabled()) {
            // "Dim" the icon like you said. You can use other alpha values if you like.
            item.getIcon().setAlpha(130);
            // Disable the menu icon
            item.setEnabled(false);

        }
        getData();
        return true;
    }

    return super.onOptionsItemSelected(item);
}