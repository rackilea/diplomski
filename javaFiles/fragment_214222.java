.withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                @Override
                public boolean onItemClick(View view, int position, IDrawerItem drawerItem)
                {
                    // do something with the clicked item :D

                    selectDrawerItem((int)drawerItem.getIdentifier(), drawerItem);
                    return true;
                }
            })