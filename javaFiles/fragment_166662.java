{
  "rules": {
        "users": {
                "$uid": {
                    ".read": true,
                            ".write": true,

                    "books": {
                                ".read": "auth != null",
                        ".write": "auth != null",
                }
            } 
         },

        "recipes": {
          "$uid": {
            ".read": "auth != null",
                ".write": "auth != null",
          }   
        },

                "cookbooks": {
          ".read": "auth != null",
          ".write": "auth != null",
        }
    } 
}