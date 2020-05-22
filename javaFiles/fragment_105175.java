{
  "request": {
    "urlPattern": "/api/1/external/client/.*",
    "method": "GET"
  },
  "response": {
    "status": "200",
    "headers": {
      "Content-Type": "application/json; charset=utf-8"
    },
    "jsonBody": {
      "id": "{{regexExtract request.requestLine.pathSegments.[4] '[0-9]*'}}"
    }
  }
}