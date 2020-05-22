import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;

import duck.reg.pack.Auth;
import java.io.IOException;
import java.math.BigInteger;

public class DBConnect {

    public String getyoutubeitemfull_details() throws SQLException, IOException{
        try {
            YouTube youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, new HttpRequestInitializer() {
                @Override
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("APP_ID").build();

            String apiKey = "Your Private Api Key"; // you can get it from https://console.cloud.google.com/apis/credentials
            YouTube.Videos.List listVideosRequest = youtube.videos().list("statistics");
            listVideosRequest.setId("yVcMc9HVXvc"); // add list of video IDs here
            listVideosRequest.setKey(apiKey);
            VideoListResponse listResponse = listVideosRequest.execute();

            Video video = listResponse.getItems().get(0);

            BigInteger viewCount = video.getStatistics().getViewCount();
            BigInteger Likes = video.getStatistics().getLikeCount();
            BigInteger DisLikes = video.getStatistics().getDislikeCount();
            BigInteger Comments = video.getStatistics().getCommentCount();
            System.out.println("[View Count] " + viewCount);
            System.out.println("[Likes] " + Likes);
            System.out.println("[Dislikes] " + DisLikes);
            System.out.println("[Comments] " + Comments);

        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }
}