myRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView rv, int dx, int dy) {
                //boolean hasStarted = state == rv.SCROLL_STATE_DRAGGING; //Scrollbar is MOVING
                //boolean hasEnded = state == rv.SCROLL_STATE_IDLE;       //ScrollBar is NOT MOVING
                //boolean isStopping = state == rv.SCROLL_STATE_SETTLING; //Scrollbar is STOPPING
                if(dy > 0){
                   myTextview.setVisibility(View.VISIBLE);
                }
            }
        });