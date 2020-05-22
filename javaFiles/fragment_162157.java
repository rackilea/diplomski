AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    LayoutInflater inflater = LayoutInflater.from(getActivity());
    View v = inflater.inflate(R.layout.internet_dialog, null);

    WebView web = (WebView) v.findViewById(R.id.web);
    EditText edit = (EditText) v.findViewById(R.id.edit);
    edit.setFocusable(true);
    edit.requestFocus();
    web.loadUrl(url);
    this.webView = web;
    builder.setView(v);

    return builder.create();