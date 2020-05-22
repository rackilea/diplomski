{
  "rules": {
    "maintenance" : {
      "$uid" : {
    ".read": "$uid === auth.uid",
    ".write": "$uid === auth.uid"
  }
},
    "properties" : {
      ".read": true,
      ".write": false
    }
}
}