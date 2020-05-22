public ShoppingCart{

        ArrayList<CartItem> Items = new ArrayList<CartItem>();

        public void AddItem(int productId)
        {
        CartItem newItem = new CartItem(productId);


            for (CartItem item:Items)
            {
                  if (item.Equal(newItem))
                  {
                    item.Quantity++;
                    return;
            }
          }


            newItem.Quantity = 1;
            Items.add(newItem);

        }
  }