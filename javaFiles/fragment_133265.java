let enableProxyForJava = process.env.ENABLE_PROXY_FOR_JAVA;
if (enableProxyForJava != undefined &&  enableProxyForJava.toLowerCase() === 'true') {
    var httpProxyJava = require('http-proxy');
    var proxyJava = httpProxyJava.createProxy();

    gutil.log(  gutil.colors.green('Enabling Proxy for Java. Set your Eureka overrides to localhost:1200.') );

    require('http').createServer(function(req, res) {
        console.log("req.headers['x-service-name'] = " + req.headers['x-service-name']);
        console.log("Before req.url:"+ req.url);

        if( req.headers['x-service-name'] != undefined){
            let change =  req.headers['x-service-name'] +req.url;
            console.log("After req.url:"+ change);
            req.url = change;
        }

        proxyJava.web(req, res, {
            target: 'http://localhost:9001/'
        });

    }).listen(1200);
}