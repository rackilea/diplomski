public class TestRow {

    public static final int LAYOUT = R.layout.list_item_test;

    public ImageView ivLogo;
    public TextView tvFadeOut;
    public TextView tvSlideIn;

    public TestRow(View view) {
        this.ivLogo = (ImageView) view.findViewById(R.id.ivLogo);
        this.tvFadeOut = (TextView) view.findViewById(R.id.tvFadeOut);
        this.tvSlideIn = (TextView) view.findViewById(R.id.tvSlideIn);

        this.ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the ImageView is clicked the animations are applied to the TextViews.
                if(tvFadeOut.getVisibility() == View.VISIBLE) {
                    fadeOutView(tvFadeOut);
                    slideInView(tvSlideIn);
                } else {
                    fadeInView(tvFadeOut);
                    slideOutView(tvSlideIn);
                }
            }
        });
    }

    public void bind(TestViewModel viewModel) {
        // Nothing to do here
    }
}