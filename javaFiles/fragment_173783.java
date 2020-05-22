List<Detail> details = myResponse.getDetails();
    for (Detail d : details) {
        if (d.getId().equals(YOUR_ID)) {
            reqDetail = d;
            name.setText(reqDetail.getName());

            Picasso.with(DisplayData.this)
                    .load(reqDetail.getName())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(image);
          }
    }