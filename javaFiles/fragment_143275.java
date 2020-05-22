RecyclerView.LayoutParams lparams = new RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
    RecyclerView recyclerView = new RecyclerView(this);
    recyclerView.setLayoutParams(lparams);

    rootview.addView(recyclerView);