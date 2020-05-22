@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.recyler_view, container, false);
    recyclerView = root.findViewById(R.id.recycler_view);
    return root;
}