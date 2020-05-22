Timeline resTimeline = downloadTimeline();
Tweet lastTweet = resTimeline.get(resTimeline.size() - 1);

while (lastTweet is younger than 24 hours) {
    TweetID lastTweetID = lastTweet.id;
    Timeline bufferTimeline = downloadTimeline(max_id = lastTweetID);
    resTimeline.addAll(bufferTimeline);
    lastTweet = resTimeline.get(resTimeline.size() - 1);
}

return resTimeline;