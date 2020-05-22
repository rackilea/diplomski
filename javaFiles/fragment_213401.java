case 0:
    Bundle bundle = new Bundle();
    bundle.putDouble("loclat", 25.4358);
    bundle.putDouble("loclang",81.8463);

    Fragment sunFragment = new SunFragment();
    sunFragment.setArguments(bundle);

    return sunFragment;