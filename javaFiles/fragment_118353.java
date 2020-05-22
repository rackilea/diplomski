Bundle args = new Bundle();
    args.putInt("sc1", sc1);
    args.putInt("sc2", sc2);
    Mdlog dialog=new Mdlog();
    dialog.setArguments(args);
    dialog.show(getFragmentManager(),"dialog");