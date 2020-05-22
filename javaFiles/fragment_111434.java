@Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch(viewType){

            case CHAT_RIGHT:
                View sender = LayoutInflater.from(getApplicationContext()).inflate(R.layout.chat_grupal_sender, parent, false);
                return new ChatGroupalHolderSender(sender);
            default:
                View left = LayoutInflater.from(getApplicationContext()).inflate(R.layout.chat_grupal_getter, parent, false);
                return new ChatGroupalHolderGetter(left);
        }


    }