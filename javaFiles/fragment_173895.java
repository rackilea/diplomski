schema {
    query: RootQuery
}

type RootQuery {
    RedditAPI: RedditAPI
}

type RedditAPI {
    users: [Users]
    subreddits(name: String!): [subreddit]
}