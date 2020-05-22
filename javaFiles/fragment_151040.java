"user": {
    "$key": {
        ".read": true,
        ".write": true,
        ".validate": "newData.hasChild('id')",
        "id": {
            ".validate": "newData.val() === 'secret id'"
        }
    }
}