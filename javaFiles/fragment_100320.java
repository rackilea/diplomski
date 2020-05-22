ch.stdout.on('data', function (data) {
    var buff = new Buffer(data);
    console.log(buff.toString('utf8')); // Or whatever encoding you're using for output
});

ch.on('exit', function (code) {
    console.log('Child process exited with code ' + code);
});