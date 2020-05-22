> db.coll.insert({_id:1,name:"name1"})
> db.coll.update({name:"name1"}, {"$push": {dependents: {name:"a", age:50}}})
> db.coll.update({name:"name1"}, {"$push": {dependents: {name:"b", age:55}}})
> db.coll.findOne()
{
        "_id" : 1,
        "dependents" : [
                {
                        "name" : "a",
                        "age" : 50
                },
                {
                        "name" : "b",
                        "age" : 55
                }
        ],
        "name" : "name1"
}
> db.coll.update({"dependents.name": "a"}, {"$push": {"dependents.dep_children": {name:"aa"}}})
can't append to array using string field name: dep_children
> db.coll.update({"dependents.name": "a"}, {"$push": {"dependents.$.dep_children": {name:"aa"}}})
> db.coll.findOne()
{
        "_id" : 1,
        "dependents" : [
                {
                        "age" : 50,
                        "dep_children" : [
                                {
                                        "name" : "aa"
                                }
                        ],
                        "name" : "a"
                },
                {
                        "name" : "b",
                        "age" : 55
                }
        ],
        "name" : "name1"
}