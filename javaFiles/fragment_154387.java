int itemCount = 0;
      Bundle bundle = new Bundle();
      for (int i = 0; i < arrayList.size(); i++) {
         Item_obj item = arrayList.get(i);
        if (item.isSelected()) {
                itemCount++;
              bundle.putString(TEXT+"i"+, item.getLanguage());
         }
        }
       bundle.putInt("itemCount",itemCount);
        info.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.container,
       info).addToBackStack(null).commit();