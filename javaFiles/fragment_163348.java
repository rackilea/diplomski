let childProcess = require('child_process').spawn(
      'java', ['-jar', 'yureJavaFile.jar']
    );

childProcess.stdout.on('data', function(data) {
    console.log(data);
});

childProcess.stderr.on("data", function (data) {
    console.log(data);
});