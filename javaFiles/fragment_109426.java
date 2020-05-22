RelativeLayout relativeLayout = (RelativeLayout) ((LinearLayout) view.findViewById(viewId)).getParent();

// getting the layoutparams might differ in your application, it depends on the parent layout
RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();

ResizeAnimation a = new ResizeAnimation(relativeLayout);
a.setDuration(500);

// set the starting height (the current height) and the new height that the view should have after the animation
a.setParams(lp.height, newHeight);

relativeLayout.startAnimation(a);