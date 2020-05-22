@Override
                        public boolean onItemLongPress(final int index, final OverlayItem item) {
                             Toast.makeText(
                                     context,
                                     "Item '" + item.getTitle() + "' (index=" + index
                                             + ") got long pressed", Toast.LENGTH_LONG).show();
                             return false;
                        }
                   }, context);