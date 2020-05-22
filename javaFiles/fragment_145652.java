$.getJson('https://www.howsmyssl.com/a/check')
.done(function (result) {
    $.post('/logs', {
                    name: 'howsmyssl',
                    level: 'info',
                    message: result
    });
})
.fail(function(err) {
    $.post('/logs', {
                    name: 'howsmyssl',
                    level: 'error',
                    message: 'could not reach howsmyssl'
    });
});