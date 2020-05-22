db.yourCollectionName.aggregate([
    {
        $project: {
            _id: 0,
            jobStatutses: { $arrayElemAt: [{ $objectToArray: "$jobStatutses" }, 0] }
        }
    }, {
        $match: { 'jobStatutses.v._id': { $in: [ObjectId("5d6d8c3a5a0d22d3c84dd6dc"), ObjectId("5d6d8c3a5a0d22d3c84dd6ed")] } }
    }
])