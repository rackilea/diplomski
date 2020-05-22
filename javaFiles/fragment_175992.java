Context context;

    public BloodVaultAdapter(Context context, int textViewResourceId, ArrayList<BloodVaultItem> objects){

        super(context, textViewResourceId, objects);
        this.context = context;
        adapterlist = objects;
    }