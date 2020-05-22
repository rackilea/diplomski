if (!collection) {
    db.createCollection('logs', next);
} else {
    next(null, collection);
}

function next(err, collection) {
    // do something
}