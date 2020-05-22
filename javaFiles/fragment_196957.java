public class NoteAdapter extends FirestoreRecyclerAdapter<Note, NoteAdapter.NoteHolder> {

public NoteAdapter(@NonNull FirestoreRecyclerOptions<Note> options) {
    super(options);
}

@Override
protected void onBindViewHolder(@NonNull NoteHolder holder, int position, @NonNull Note model) {
    holder.textViewTitle.setText(model.getTitle());
    holder.textViewDescription.setText(model.getDescription());
    holder.textViewPriority.setText(String.valueOf(model.getPriority()));
}

@NonNull
@Override
public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,
            parent, false);
    return new NoteHolder(v);
}

public void deleteItem(int position) {
    getSnapshots().getSnapshot(position).getReference().delete();
}

class NoteHolder extends RecyclerView.ViewHolder {
    TextView textViewTitle;
    TextView textViewDescription;
    TextView textViewPriority;

    public NoteHolder(View itemView) {
        super(itemView);
        textViewTitle = itemView.findViewById(R.id.text_view_title);
        textViewDescription = itemView.findViewById(R.id.text_view_description);
        textViewPriority = itemView.findViewById(R.id.text_view_priority);
    }
}