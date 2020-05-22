{
  "users": {
    "user1": {
      "name": "User 1",
      "groups": {
         "group1": true,
         "group2": true,
         "group3": true
      },
    "user2": {
      "name": "User 2",
      "groups": {
         "group2": true,
         "group3": true
      }
    },
    ...
  },
  "groups": {
    "group1": {
      "name": "Group 1",
      "members": {
        "user1": true
      },
    "group2": {
      "name": "Group 2",
      "members": {
        "user1": true,
        "user2": true
      },
    "group3": {
      "name": "Group 3",
      "members": {
        "user1": true,
        "user2": true
      }
    },
    ...
  }
}