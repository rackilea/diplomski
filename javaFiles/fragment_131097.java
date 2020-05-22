if (getIntent().getExtras() != null) {
        Bundle bundle = getIntent().getExtras();
        mMerkProduk = bundle.getString(Constant.BUNDLE_MERK_PRODUK); //MERK kategori

    //Toolbar
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    setTitle(mMerkProduk);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    dbHandler = new DBHandler(this);
    }

    initRecyclerView();
    cekDataRecyclerView();