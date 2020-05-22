child.on('close', function (exitCode) {
    if (exitCode !== 0) {
        console.error('Something went wrong!');
    }
});

// If you’re really just passing it through, though, pass {stdio: 'inherit'}
// to child_process.spawn instead.
child.stderr.on('data', function (data) {
    process.stderr.write(data);
});