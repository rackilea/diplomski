@Override  
           protected void onActivityResult(int requestCode, int resultCode, Intent data)  
           {  
               super.onActivityResult(requestCode, resultCode, data);  
               if(requestCode == 121)  
                  {  
                    // Update the values according to you, I am using sample key-value.
                    String updatedCost = data.getStringExtra("updatedCost");   
                    List<CartItems> cartItems = adapter.getCartItemsFromAdapter();
                    CartItems cartItemObj = cartItems.get(clickedPosition);
                    cartItemObj.setTotalCost(updatedCost);
                    adapter.notifyDataSetChanged(); // Calling this method will quickly reflect your changes to listView.
                  }  
         }