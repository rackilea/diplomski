@Override
    public void onResume(){
          super.onResume(); 
          if (linearLayoutState != null) {
             linearLayoutManager.onRestoreInstanceState(linearLayoutState);
          } 
             // Here comes the code to populate your data. 
             // I'm not sure how you do this, so I just copy/paste your code
             for (ListItem item : list){
                    newList.add(new ListItemi(item));
             }
             // Now instatiate and add the adapter to the RecyclerView
             adapter = new RecyclerAdapter(newList);
             recyclerView.setAdapter(adapter);
          }
    }