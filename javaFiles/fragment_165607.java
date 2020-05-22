VideoStatus status = new VideoStatus();
status.setPublicStatsViewable(true);
video.setStatus(status);

// (your existing code)
YouTube.Videos.Insert videoInsert = 
    youTube.videos().insert("snippet,statistics,status", video, videoInputStreamContent);
...