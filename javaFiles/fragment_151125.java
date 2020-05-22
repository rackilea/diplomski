http = require('http');
server = http.createServer( function(req, res) {
    if (req.method == 'POST') {
        console.log("POST");
        var body = '';
        req.on('data', function (data) {
            body += data;
            console.log("Partial body: " + body);
        });
        req.on('end', function () {
            console.log("Body: " + body);
        });
        res.writeHead(200, {'Content-Type': 'text/html'});
        res.end('post received');
    } else if(req.method === 'GET') {
        console.log("GET");
        var params = req.url.split('?');
        params = params.length > 1 ?  params[1] : "";
        console.log('params : ' + params);

        var html = '<html><body><h1>' + params+ '</h1></body>';
        res.writeHead(200, {'Content-Type': 'text/html'});
        res.end(html);
    }

});

port = 3000;
host = '127.0.0.1';
server.listen(port, host);
console.log('Listening at http://' + host + ':' + port);