collection.update(
{
    "unique_id": idd
    // add any other field here that makes up your filter
},
{
    $set: { "unique_id": uid },
    $set: { "user": { "id": id, "first": first, "last": last } },
    // add any other field to set as part of the update
    $setOnInsert: {"created_timestamp": new Date()}
}, {
    upsert: true
})