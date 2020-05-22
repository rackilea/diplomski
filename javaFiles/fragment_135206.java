public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    getDialog().setOnShowListener(new DialogInterface.OnShowListener() {
        @Override
        public void onShow(DialogInterface dialog) {
            BottomSheetDialog d = (BottomSheetDialog) dialog;
            coordinatorLayout = (CoordinatorLayout) d.findViewById(R.id.locUXCoordinatorLayout);
            bottomSheetInternal = d.findViewById(R.id.locUXView);
            bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetInternal);
            bottomSheetBehavior.setHidable(false);
            BottomSheetBehavior.from((View)coordinatorLayout.getParent()).setPeekHeight(bottomSheetInternal.getHeight());
            bottomSheetBehavior.setPeekHeight(bottomSheetInternal.getHeight());
            coordinatorLayout.getParent().requestLayout();

        }
    });