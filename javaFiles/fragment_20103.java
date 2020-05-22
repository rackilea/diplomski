> db.pseudo.find({ "pseudo" : "gPlayer"}).pretty()
{
    "_id" : ObjectId("4f904ebb5bebd4375b759c90"),
    "email" : "email",
    "password" : "password",
    "pos" : [
        {
            "X" : "90.45"
        },
        {
            "Y" : "90.45"
        },
        {
            "Z" : "90.45"
        }
    ],
    "pseudo" : "gPlayer",
    "status" : "1"
}
> db.pseudo.update({"pseudo" : "gPlayer"}, { "$set" : { "status" : 0 , "pos.0.X" : "0" , "pos.1.Y" : "0" , "pos.2.Z" : "0"}})
> db.pseudo.find({ "pseudo" : "gPlayer"}).pretty()
{
    "_id" : ObjectId("4f904ebb5bebd4375b759c90"),
    "email" : "email",
    "password" : "password",
    "pos" : [
        {
            "X" : "0"
        },
        {
            "Y" : "0"
        },
        {
            "Z" : "0"
        }
    ],
    "pseudo" : "gPlayer",
    "status" : 0
}
>