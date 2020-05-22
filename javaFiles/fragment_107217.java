// Adapter:

public class ContentAdapter extends RecyclerView.Adapter<holder> {

    private Context context;
    private List<Model> models;
    private AdapterType type;

    public ContentAdapter(Context context, List<Model> models, AdapterType type){
        this.context = context;
        this.models = models;
        this.type = type;
    }

   // other code here

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.text.setText(models.get(position).getTitle());
        holder.image.setImageResource(models.get(position).getImage());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                switch (type) {
                    case AdapterType.JAVA:
                        // Logic
                    case AdapterType.HTML:
                        // Logic
                }
            }
        });
    }
}

// Enum:
public enum AdapterType {
    JAVA, HTML
}