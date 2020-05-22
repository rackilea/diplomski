public static List<String> getUploadedVideoIds() throws IOException
{
    YouTube youtube;
    List<String> scopes = Lists
            .newArrayList("https://www.googleapis.com/auth/youtube.readonly");
    Credential credential = Auth.authorize(scopes, "myuploads");

    youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY,
            credential).setApplicationName(
            "youtube-cmdline-myuploads-sample").build();

    YouTube.Channels.List channelRequest = youtube.channels().list(
            "contentDetails");
    channelRequest.setMine(true);
    channelRequest.setFields("items/contentDetails,nextPageToken,pageInfo");
    ChannelListResponse channelResult = channelRequest.execute();

    List<Channel> channelsList = channelResult.getItems();

    String uploadPlaylistId = channelsList.get(0).getContentDetails()
            .getRelatedPlaylists().getUploads();

    List<PlaylistItem> playlistItemList = new ArrayList<PlaylistItem>();

    YouTube.PlaylistItems.List playlistItemRequest = youtube
            .playlistItems().list("id,contentDetails,snippet");
    playlistItemRequest.setPlaylistId(uploadPlaylistId);

    playlistItemRequest
            .setFields("items(contentDetails/videoId),nextPageToken,pageInfo");

    String nextToken = "";

    do
    {
        playlistItemRequest.setPageToken(nextToken);
        PlaylistItemListResponse playlistItemResult = playlistItemRequest
                .execute();

        playlistItemList.addAll(playlistItemResult.getItems());

        nextToken = playlistItemResult.getNextPageToken();
    } while (nextToken != null);

    List<String> videoIds = new ArrayList<>();

    for (PlaylistItem playListItem : playlistItemList)
    {
        videoIds.add(playListItem.getContentDetails().getVideoId());
    }

    return videoIds;
}