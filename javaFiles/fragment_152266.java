-----------------------------------com.your.package.name.Listing.java-----------------------------------

package com.your.package.name;

import java.util.List;

public class Listing {
    private int section;
    private List<Video> videos = null;

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}


-----------------------------------com.your.package.name.Video.java-----------------------------------

package com.your.package.name;

public class Video {
    private String title;
    private String videoUrl;
    private String thumbnail;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}