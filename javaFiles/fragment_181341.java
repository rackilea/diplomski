db.collection.update(
    { "name": "Goku" },
    {
        "$set": {
            "type": "Super Saiyan",
            "family.son": "Gohan",
            "family.father": "Bardock"
        }
    }
)