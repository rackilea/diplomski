"paths": {
  "/api/rmt-create-request": {
    "post": {
      "tags": [
        "RMT APIs"
      ],
      "description": "Return newly created request data",
      "operationId": "create-new-rmt-request",
      "requestBody": {
        "content": {
          "multipart/form-data": {    // or  "application/x-www-form-urlencoded" - depending on what you need
            "schema": {
              "type": "object",
              "properties": {
                "rootNodeName": {
                  "type": "string",
                  "description": "Root node class name for item"
                }
              }
            }
          }
        }
      }
    }
  }
}