new BottomSheet.Builder(MainActivity.this)
                    .setSheet(R.menu.menu)
                    .grid()
                    .setTitle("Lets Some Fun")
                    .setListener(new BottomSheetListener() {
                        @Override
                        public void onSheetShown(@NonNull BottomSheet bottomSheet) {

                        }

                        @Override
                        public void onSheetItemSelected(@NonNull BottomSheet bottomSheet, MenuItem menuItem) {
                                if(menuItem.getItemId() == R.id.share) {
                                Toast.makeText(MainActivity.this, "Share" , Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onSheetDismissed(@NonNull BottomSheet bottomSheet, int i) {

                        }
                    })
                    .show();