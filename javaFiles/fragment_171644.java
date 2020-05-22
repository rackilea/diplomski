val music = facebook.fetchConnections(userPage.id, "music", Page::class.java,
            PagingParameters(25, 0, null, null).toMap(), "id,name,,genre")
for (musicLiked in music)
{
    println("likes: ${musicLiked.name}, genre: ${musicLiked.genre}")
}