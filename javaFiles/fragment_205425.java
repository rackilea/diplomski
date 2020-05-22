@Override
        public View getInfoContents(Marker marker) {
            View v = getLayoutInflater().inflate(R.layout.info_window_layout, null);
            Spanned spannedContent = Html.fromHtml(htmlString);
            TextView html = (TextView) v.findViewById(R.id.html);
            html.setText(spannedContent, TextView.BufferType.SPANNABLE);
            return v;
        }