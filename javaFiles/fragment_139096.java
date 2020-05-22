adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), SaladDetailActivity.class);
                intent.putExtra(SaladDetailActivity.EXTRA_SALAD, position+1);
                getActivity().startActivity(intent);
            }
        });