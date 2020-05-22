ViewGroup parent = (ViewGroup) mapView.findViewById(Integer.parseInt("1")).getParent();
        View compassButton = parent.getChildAt(4);
        /* now set position compass */
        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) compassButton.getLayoutParams();
        rlp.addRule(RelativeLayout.ALIGN_PARENT_END, 0);
        rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        rlp.addRule(RelativeLayout.ALIGN_PARENT_START);
        rlp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 0);
        Resources r = context.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, r.getDisplayMetrics());
        rlp.setMargins(0, (int)px,0, 0); // 160 la truc y , 30 la  truc x
        px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, r.getDisplayMetrics());
        rlp.setMarginEnd((int)px);

        compassButton.setLayoutParams(rlp);