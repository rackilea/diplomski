PopupMenu popup = new PopupMenu(context, view_anchor);
popup.inflate(R.menu.your_menu);
popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.button1:
                                    //code when button1 is clicked
                                    popup.dismiss();
                                    break;
                                case R.id.button2:
                                    //code when button2 is clicked
                                    popup.dismiss();
                                    break;
                            }
                            return false;
                        }
                    });
popup.show();