try {
         if((selected_year != null & selected_year.length > 0 ) & (tv_month.getText().toString() != null & tv_month.getText().toString().length > 0))
         {
            send_date();
         }

  } catch (JSONException e) {
         e.printStackTrace();
  }