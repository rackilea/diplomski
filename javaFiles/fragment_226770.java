public DynamicPopUpMenu{

    private Map<String,FeatureList> storedOption = new HashMap();

    public static void main(final Context context,List<FeatureList> featureList){

        int count = 0;
        PopupMenu menu = new PopupMenu(context, featureList);
        for(FeatureList f:featureList) {
            MenuItem item = menu.getMenu().add(f.key);
            storedOption.put(f.key, f);
            count++;
        }

        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
               AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                int id = item.getItemId();
                FeatureList mFeatureList = (FeatureList)storedOption(id)
                new ShowToast(context,Integer.toString(value)); // show position in a toast
                return true;
            }
        });

        menu.show();
    }

  }