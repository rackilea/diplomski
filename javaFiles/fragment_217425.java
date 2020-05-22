Urlname = snapshot.child("url").getValue(String.class);
            jlistAdapter.notifyDataSetChanged();
            webstreamsArray.add(streamname);
            urlList.add(Urlname);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                   WebView webView = (WebView) findViewById(R.id.webView1);
                    webView.setVisibility(View.VISIBLE);
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.loadUrl(urlList.get(i));

                }
            });
        }