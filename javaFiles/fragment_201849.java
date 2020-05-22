import flash.external.ExternalInterface;

//in flash video player code,
//have variables for video ID and current player position
//every 5 seconds, call:
ExternalInterface.call("UpdateViewData", videoId, currentPlayerPosition);

//this will invoke a JS function on the host page named "UpdateViewData"
//and pass in the provided arguments