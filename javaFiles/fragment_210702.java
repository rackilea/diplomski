View.OnDragListener DropListener = new View.OnDragListener() {
      @Override
      public boolean onDrag(View view, DragEvent event) {
          int action = event.getAction();
          View draggedView = (View) event.getLocalState();
          //view is the country where the flag was dropped, draggedView is the flag you dropped
          //below we check if the correct flag is dropped in the correct country

      switch (event.getAction()){
        case DragEvent.ACTION_DROP: 
          for (int i; i< countryImages.length(); i++){
               if (draggedView.getId() == countryFlags[i] && view.getId()== countryImages[i])
                   draggedView.setImageResource(R.drawable.vcheckmark); 

          }            
          break;
        default:
          break;
        }
        return true;
      }   
    };