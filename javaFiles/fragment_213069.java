public class MCustomObject{
    private final String customId;

    public MCustomObject(final MActivity parent, final String customId, String xyz){ 
        this.customId = customId;
        LayoutInflater layoutInflater = LayoutInflater.from(parent);
        view = layoutInflater.inflate(R.layout.m_custom_object_layout, null);
        button = (Button) view.findViewById(R.id.mButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // do your other stuff
               parent.removeCustomObject(customId);
            }
        });
    }

    public String getId() {
        return customId;
    }