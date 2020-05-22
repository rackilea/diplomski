<string name="graphiql_detail_search">
{
  user(ident: "JohnDoe") {
    myStory {
      description
      placements(first: 3) {
        edges {
          node {
            mediaItemType
            mediaItem {
              ...VideoFragment
              ...PhotoFragment
            }
          }
        }
      }
    }
  }
}

fragment VideoFragment on Video {
  videoHTML
}

fragment PhotoFragment on Photo {
  url(size: 10)
}