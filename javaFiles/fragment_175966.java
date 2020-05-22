app.get('/videoStream', function(req, res) {

    Video.findOne({_id: req.query.idVideo}, function(err, video) {
        if (err)
            console.log("err: " + err);
        if (video == null)
            console.log("video not found");
        res.setHeader('Content-Type', 'video/mp4');
        res.sendfile('/home/video/video.mp4', function (err) {
            if (err)
                console.log(err);
        });

    });
});