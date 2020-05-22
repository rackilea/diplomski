Bundle bundle = new Bundle();
    String imgPath = "path/to/my/image";
    bundle.putString("imgPath", imgPath );
    PictureFragment frag = new PictureFragment();
    frag.setArguments(bundle);
    transaction.replace(R.id.fragment_single, frag);
    transaction.commit();