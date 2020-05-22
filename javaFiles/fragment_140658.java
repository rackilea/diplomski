{
  "rules": {
    "rooms": {
      "$roomid": {
        "users": {
          "$slot": {
            ".write": "!data.exists()"
          }
        }
      }
    }
  }
}