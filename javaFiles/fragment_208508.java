btnWork.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            workButtonPressed();
           // TODO SET UP THIS ARROW THAT TRANSFERS MONEY TO INVESTMENTS

          if(checkingBalance > 1199.99f) {
              ivArrow.setVisibility(View.VISIBLE);
          }
        }
    });