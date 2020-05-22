((GridLayoutManager)mLayoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
         @Override
         public int getSpanSize(int position) {
            if ( albumList.get(position).getName().length() == 0)
               return 2;
            return 1;
         }
      });