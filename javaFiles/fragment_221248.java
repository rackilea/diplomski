private LinearLayout mLayout;

private void doStuff(ViewGroup container) {
    LinearLayout layout = (LinearLayout) container.findViewById(0);

    layout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ...
        }
    });

    mLayout = layout;
    fooTheBar(layout);   
}

private void fooTheBar(LinearLayout layout) {
    ...
}