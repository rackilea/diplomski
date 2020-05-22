@Override
public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle 
  savedInstanceState) {
  bindings = DataBindingUtil.inflate(inflater, R.layout.layout, container, false)
  bindings.lifecycleOwner = fragment        
  return binding.root
}