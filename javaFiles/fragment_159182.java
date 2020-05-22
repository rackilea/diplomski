@Override
    public void onDataChange(@NonNull DataSnapshot data) {
        // That Run When I Want To Get Data From FireBase

        for (DataSnapshot snapshot : data.getChildren()){
            Note note = snapshot.getValue(Note.class);
            mNoteList.add(note);
        }
        noteAdapter adapter = new noteAdapter(MainActivity.this , mNoteList);
        listViewNote.setAdapter(adapter);
    }