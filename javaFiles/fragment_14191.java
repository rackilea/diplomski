db.films.aggregate([{
    $unwind: "$Actors"

}, {
    $match: {
        "Actors.First name": {$regex: "^name.*"}
    }
}, {
    $group: {
        _id: "$Actors.actorId",
        "first": {
            $first: "$Actors.First name"
        },
        "last": {
            $first: "$Actors.Last name"
        }
    }
}])