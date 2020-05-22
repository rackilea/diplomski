{
    "status": { "$in": [ "a","b","c" ] },
    "$or": [
        { "flightDetails.0": { "$exists": true } },
        { "flightDetails": { "$exists": false } }
    ]
}