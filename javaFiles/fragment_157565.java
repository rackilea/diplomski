mNewsAdapter.setOnItemClickListener(new NewsAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                News currentNews = news.get(position);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentNews.getUrl()));
                if (intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });