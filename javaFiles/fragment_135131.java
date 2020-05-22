mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

        if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
            int position = recyclerView.getChildLayoutPosition(child);
            Note selectedNote = mNotes.get(position);
            Intent editorIntent = new Intent(getActivity(), NoteEditorActivity.class);
            editorIntent.putExtra("id", selectedNote.getId());
            startActivity(editorIntent);
        }
        System.out.print("Failed to load Editor class.");
        return false;

    }