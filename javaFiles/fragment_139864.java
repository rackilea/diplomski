ArrayList<String> ids = new ArrayList
users.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
            notes.clear();
            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                note = dataSnapshot1.getValue(Note.class);
                notes.add(note);

                ids.add(dataSnapshot1.getKey());//saving id of each child
            }
            adapter = new NotesAdapter(notes, getActivity());
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
            RVNotesList.setLayoutManager(layoutManager);
            RVNotesList.setAdapter(adapter);
            adapter.setOnNoteClickListener(new NotesAdapter.OnNoteClickListener() {
                @Override
                public void onNoteClick(final int position) {
                   users.child(ids.get(position)).removeValue();
                }
            });
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });