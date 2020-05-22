@Override
public void onClick(View view) {
    PopupMenu popup = new PopupMenu(MainActivity.this, view);
    popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_copy:
                    //your code here
                    break;
                case R.id.action_forvard:
                    //your code here
                    break;

            }
            return true;
        }
    });

    popup.show();
}