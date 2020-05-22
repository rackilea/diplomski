if(checkStatus==null)
                {

                }
                else
                {
              Log.d("status", checkStatus);
               if(checkStatus.equalsIgnoreCase("Yes"))
               {
                   holder.status.setImageResource(R.drawable.acceptbuttons);
               }

               else if(checkStatus.equalsIgnoreCase("No"))
               {
                    holder.status.setImageResource(R.drawable.declinebuttons);
               }
               else
               {


               }
                }