ares = tres.split("-");
    if (!ares[0].toString().equals("0")) {
        for (int i = 0; i <= ares.length - 1; i++) {
            adob = ares[i].toString().split(",");
            // txtv = new TextView(Albums.this);
            valueTV = new TextView(Albums.this);
            valueTV.setText(adob[0].toString() + "[" + adob[1].toString()
                    + "]");
            // valueTV.setId(i);
            valueTV.setGravity(Gravity.CENTER);
            valueTV.setLayoutParams(new LayoutParams(
                    LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            valueTV.setTextSize(20);
            valueTV.setTextColor(Color.BLUE);
            valueTV.setClickable(true);
            valueTV.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    imgArrayList = null;
                    new GetAlb(adob[2].toString().trim()).execute();
                    if (!strimgurls[0].toString().equals("0")) {
                        for (int j = 0; j <= strimgurls.length - 1; j++) {
                            String[] tmpimgurls = strimgurls[j].toString()
                                    .split("_");
                            String extn = strimgurls[j]
                                    .toString()
                                    .trim()
                                    .substring(
                                            strimgurls[j].toString().trim()
                                                    .lastIndexOf("."));
                            String fname = strimgurls[j].toString().trim()
                                    .replace(extn, "_b" + extn);
                            String temp = methods.albimg.trim()
                                    + tmpimgurls[1].toString() + "/"
                                    + tmpimgurls[2].toString() + "/"
                                    + tmpimgurls[3].toString() + "/"
                                    + fname.trim();
                            imgArrayList.add(temp.trim());
                        }
                        String[] imgulls = imgArrayList
                                .toArray(new String[imgArrayList.size()]);
                        Intent i = new Intent(Albums.this,
                                ImageGridActivity.class);
                        i.putExtra("imgurls", imgulls);
                        startActivity(i);
                    }
                }
            });
            lnrLayout.addView(valueTV);
        }
    }