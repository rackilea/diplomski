@Override
public void onBindViewHolder(MyViewHolder holder, int position) {
    final Video video = videosList.get(position);
    holder.title.setText(video.getTitle());
    holder.description.setText(video.getDescription());

    holder.downloadButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String url ="http://"+ AppController.serverAddr +":"+AppController.port +"/video/"+video.getUrl()+video.getExtension();

            // Pass the progressBar here. You might have to set it as a final variable. 
            DownloadFileFromURL downloadFileFromURL = new DownloadFileFromURL(SyncUtil.VIDEOFILE, holder.progressBar);
            downloadFileFromURL.execute(url,video.getTitle(),video.getDescription());

        }
    });
    holder.bind(video,listener);
}