gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            final ClipData dragData = new ClipData("dragLabel", new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, null);
            view.startDrag(dragData,  // the data to be dragged
                    new View.DragShadowBuilder(view), // the drag shadow builder
                    null,
                    0          // flags (not currently used, set to 0)
            );
            return true;
        }
    });