YouTube yt = ...         // your reference to YouTube
String broadcastId = ... // your broadcast Id

String newStreamId = ... // identifier of stream you want to bind
String apiKEy = ...      // your API key

// you can define other response parts if you want more or don't want some of these
String responseParts = "id,status,contentDetails.boundStreamId";

yt.liveBroadcasts().bind(broadcastId, responseParts)
    .setApiKey(apiKey)
    .setStreamId(streamId)
    // other data you might want in request
    .execute()