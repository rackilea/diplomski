public native static boolean getUserVideo(UserWebcamCallback callback)/*-{
            localStream;
            if(navigator.webkitGetUserMedia) {
                navigator.webkitGetUserMedia(
                    {video: true, toString: function() {return "video";}},
                    function(stream) {
                        var s = window.URL.createObjectURL(stream);

            localStream = stream;
                        $entry(callback.@com.test.ElementalUtils.UserWebcamCallback::onSuccess(Ljava/lang/String;)(s));
                        },
                    function() {
                        $entry(callback.@com.test.ElementalUtils.UserWebcamCallback::onFail()());
                    });
                return true;
            } else {
                return false;
            }
        }-*/;

public native static void stopVideo()/*-{
localStream.getTracks()[0].stop();
}-*/