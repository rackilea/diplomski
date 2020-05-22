db.collection.aggregate([
    {$unwind:'$key2'}, 
    // find the documents having key2.subkey1 = 'america.south.#' or key2.subkey1 = 'america.south.gas'
    {$match:{'key2.subkey1':{$in:['america.south.#','america.south.gas']}}},
    // limit the output to only those key2.subkey2 entries for which the associated key2.subkey1 match the previous $match clause
    {$group:{_id:0,'subkey2':{$push:'$key2.subkey2'}}},
    // only return subkey2
    {$project: {_id: 0, 'subkey2':1}}
])