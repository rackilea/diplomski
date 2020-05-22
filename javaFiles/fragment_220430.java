@Override
public void itemClicked(View view, int position) {
    Toast.makeText(getActivity(), "clicked " + (position+1), Toast.LENGTH_SHORT).show();
    WebView webView = (WebView) getActivity().findViewById(R.id.webview);
    webView.loadUrl(...your url here...)
}