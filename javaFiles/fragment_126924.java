case R.id.companies:
                pushFragment(new CompaniesFragment());
                setTitle("Companies");
                if (menu != null){
                    MenuItem item_down = menu.findItem(R.id.add);
                    item_down.setVisible(true);
                }
                break;