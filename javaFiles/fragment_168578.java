for(int i=0;i<dsize;i++) {
    tvvv.setText(ddList.get(i));
}

    for(int i=0;i<ssize;i++){
        String source = ssList.get(i);
        for(int j=0;j<dsize;j++) {
            String destination = ddList.get(j);
            String src = myDb.findBus(source, destination);

                TextView tvv = (TextView) findViewById(R.id.textView7);
                tvv.setText(src);

        }

    }

}