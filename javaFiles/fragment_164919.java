setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);
        db.AddNote(new Note("12313", "jkfsabk"));

        ArrayList<Note> notes = db.getAllNotes();
        String log = null;
        for (Note c: notes){
             log = "NAME: " + c.getNoteName() + " DESCRIPTION: " + c.getNoteDescription() + "\n";
          //  text = text + log;
        }
        Toast.makeText(this, log+"" , Toast.LENGTH_SHORT).show();