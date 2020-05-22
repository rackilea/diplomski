Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String newString= extras.getString("intent");
            switch(newString){
                case "foodButton":
                      fo.setVisibility(View.VISIBLE);
                      puppy.setVisibility(View.GONE);
                      soc.setVisibility(View.GONE);
                      break;
                case "animaButton":
                      fo.setVisibility(View.GONE);
                      puppy.setVisibility(View.VISIBLE);
                      soc.setVisibility(View.GONE);
                      break;
                case "hobButton":
                      fo.setVisibility(View.GONE);      
                      puppy.setVisibility(View.GONE);
                      soc.setVisibility(View.VISIBLE);
                      break;
               }
        }