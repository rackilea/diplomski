const query = {
    username: req.body.username,
    password: req.body.password
}

db.collection('users').findOne(query, function (err, user) {
    console.log(user);
});