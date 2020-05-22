`SharedId mainId = new Title();
    SharedId detailId = new Data();
    Bundle bundle = getIntent().getExtras();
    if (bundle != null) {
        mainId = bundle.containsKey("ID") ? bundle.getParcelable("ID") : null;
        detailId = bundle.containsKey("idDetail") ? 
     bundle.getParcelable("idDetail") : null;
    }
    if (mainId != null) {
        this.detailId = mainId.getSharedDataId();
        tvToolbarTitle.setText(mainId.getHeader());
    }
    if (detailId != null) {
        this.mainId = detailId.getSharedDataId();
        tvToolbarTitle.setText(detailId.getHeader());
    }