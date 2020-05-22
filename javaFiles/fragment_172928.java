if (child == null) {
    layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    child = layoutInflater.inflate(R.layout.listcell, null);
    mHolder = new Holder();
    mHolder.button1= (Button) child.findViewById(R.id.misa1);

    child.setTag(mHolder);
} else {
mHolder = (Holder) child.getTag();
}
//transfer to TextView in screen
mHolder.txtstafid.setText(stafid.get(pos));
mHolder.txtnama.setText(nama.get(pos));
mHolder.txtjbt.setText(jbt.get(pos));

mHolder.button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // call DownloadFileAsync 
       String fileURL = "http://XXXXXXX/sound/audio.mp3";
        new DownloadFileAsync(mContext).execute(fileURL);
        }
    });

return child;
 }