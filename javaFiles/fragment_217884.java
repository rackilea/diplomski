notesStore.sync();

currentNote.dirty = false;

//Tri des notes
notesStore.sort([
    { property: 'dateCreated', direction: 'DESC'}
]);

this.activateNotesList();