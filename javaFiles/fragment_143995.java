class newClass extends LazyAdapter implements AdapterView.OnItemLongClickListener, AdapterView.OnClickListener {

 @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        currentNote = allNotes.get(position);
        AppCompatImageView deleteButton = (AppCompatImageView) view.findViewById(R.id.listItemDeleteButton);
        deleteButton.setOnClickListener(this);
        deleteButton.setVisibility(View.VISIBLE);
        deleteButton.animate().alpha(1.0f).setDuration(5000);
        return true;
    }
}

 @Override
            public void onClick(View view) {
                deleteCurrentNote();


  }
    }