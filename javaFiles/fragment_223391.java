listi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> parent, View view,final int position, long id) {
    final PopupMenu pop = new PopupMenu(Danger.this, listi);
    pop.getMenuInflater().inflate(R.menu.menu_location, pop.getMenu());
    pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {

                case R.id.Remove:
                   if(counterList.get(position) >= 2){

                       items.remove(position); // remove current position item from arraylist adapter and notify data set changed
                       counterList.remove(position); // remove the current position element from counter list too
                   } else {
                        counterList.set(position, counterList.get(position) + 1); // if 3 clicks have not happened then increase the counter.
                   }

            }//swithc
            return false;