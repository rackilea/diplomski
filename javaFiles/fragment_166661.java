{
  "rules": {
    "recipes-309da": {
      "cookbooks": {
        ".read": "auth != null",
            ".write": "auth != null",
    },

    "recipes": {
        ".read": "auth != null",
            ".write": "auth != null",
    },

    "users": {
      "$uid": {
          ".read": "auth != null",
                ".write": "auth != null",
      }
    }
   }
  }
 }