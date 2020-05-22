@Override
public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
{
    if (getArguments() != null)
    {
        String itemFromFirstFragment = getArguments().getString("selectedSpinnerItemKey");
    }
}