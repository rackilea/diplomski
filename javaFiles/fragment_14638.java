db.post.update(
    { "commentsList.id": "123" },
    {
        "$inc": { "commentsList.$.numberOfLikes": 1 }
    }
)