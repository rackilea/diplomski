"rules": {
  "profiles": {
    "$uid": {
      ".read": "$uid === auth.uid",
      ".write": "$uid === auth.uid"
    }
  },
  "blogs": {
    ".read": true"
  }
}