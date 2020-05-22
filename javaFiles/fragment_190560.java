const PROXY_TARGET = 'http://localhost:9501';
const webpack = require('webpack');
const webpackDevMiddleware = require('webpack-dev-middleware');
const webpackHotMiddleware = require('webpack-hot-middleware');
const config = require('./webpack.config-hot-middleware');
const express = require('express');
const proxy = require( 'http-proxy' );
const proxyServer = proxy.createProxyServer( );

proxyServer.on('error', function(err, req, res) {
    console.log('Proxy error: ' + err);
    res.writeHead(500, {
        'Content-Type': 'text/plain'
    });
    res.end('Proxy request to ' + PROXY_TARGET + ' failed. Please make sure your Java server is running!');
});

const app = new require('express')();
const port = 3000;

const compiler = webpack(config);
app.use(webpackDevMiddleware(compiler, { noInfo: true, publicPath: config.output.publicPath }));
app.use(webpackHotMiddleware(compiler));
app.use('/', function(req, res) {
    proxyServer.web(req, res, {
        target: PROXY_TARGET
    });
});

app.listen(port, function(error) {
    if (error) {
        console.error(error);
    } else {
        console.info('==> Listening on port %s.);
    }
});