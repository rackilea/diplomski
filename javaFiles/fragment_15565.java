for (int titleResId : demo.tabs()) {
    Bundle args = new Bundle();
    args.putString("page_source", ...);
    pages.add(FragmentPagerItem.of(getString(titleResId), DemoFragment.class, args));
}

WebView browser = (WebView) view.findViewById(R.id.webView);
browser.loadUrl(getArguments().getString("page_source"));