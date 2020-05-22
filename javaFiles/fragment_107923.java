{
  "swagger": "2.0",
  "info": {
    "description": "description",
    "version": "0.2",
    "title": "title",
    "termsOfService": "termsOfService",
    "contact": {
      "name": "contact",
      "url": "http://contact.org",
      "email": "info@contact.org"
    },
    "license": {
      "name": "Apache2",
      "url": "http://license.org/license"
    }
  },
  "host": "host.org",
  "tags": [
    {
      "name": "a"
    },
    {
      "name": "b"
    }
  ],
  "schemes": [
    "https"
  ],
  "paths": {
    "/a/getA": {
      "get": {
        "tags": [
          "a"
        ],
        "summary": "Method for A.",
        "description": "",
        "operationId": "getA",
        "produces": [
          "application/json"
        ],
        "parameters": [],
        "responses": {
          "200": {
            "description": "OK"
          },
          "401": {
            "description": "Unauthorized"
          },
          "404": {
            "description": "Not found"
          },
          "500": {
            "description": "Internal server problems"
          }
        }
      }
    },
    "/b/getA": {
      "get": {
        "tags": [
          "b"
        ],
        "summary": "Method for B.",
        "description": "",
        "operationId": "getA",
        "produces": [
          "application/json"
        ],
        "parameters": [],
        "responses": {
          "200": {
            "description": "OK"
          },
          "401": {
            "description": "Unauthorized"
          },
          "404": {
            "description": "Not found"
          },
          "500": {
            "description": "Internal server problems"
          }
        }
      }
    }
  }
}