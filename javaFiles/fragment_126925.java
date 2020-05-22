case R.id.home:
                pushFragment(new HomeFragment());
                setTitle("Dashboard");
                if (menu != null){
                    MenuItem item_down = menu.findItem(R.id.add);
                    item_down.setVisible(false);
                }
                break;