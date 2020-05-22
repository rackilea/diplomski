{
   "rules": {
    // By default all nodes are private
    ".read":false,
    ".write":false,

    "Users": {
      ".read": true,
      ".write": "(auth!=null)",
      ".indexOn" : ["username"]
      }
   }
}