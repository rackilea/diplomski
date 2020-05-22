{
  "swagger": "2.0",
  "info": {
    "version": "1.0.0",
    "title": ""
  },
  "host": "localhost:7070",
  "basePath": "/assets/rest",
  "tags": [
    {
      "name": "Assets"
    }
  ],
  "schemes": [
    "http"
  ],
  "paths": {
    "/assets/{id}": {
      "get": {
        "tags": [
          "Assets"
        ],
        "summary": "Fetches information about a single asset",
        "description": "",
        "operationId": "fetchAssetDetail",
        "produces": [
          "application/json"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "type": "integer",
            "format": "int32"
          }
        ],
        "responses": {
          "200": {
            "description": "successful operation",
            "schema": {
              "$ref": "#/definitions/AssetResponse"
            }
          }
        }
      }
    }
  },
  "definitions": {
    "Asset": {
      "type": "object",
      "required": [
        "name",
        "owner",
        "purchaseDate",
        "type"
      ],
      "properties": {
        "id": {
          "type": "integer",
          "format": "int32",
          "description": "The internal unique ID of the Asset"
        },
        "name": {
          "type": "string",
          "description": "Name of the asset"
        },
        "type": {
          "type": "string",
          "description": "Name of the asset",
          "enum": [
            "Laptop",
            "Desktop",
            "Internet Dongle",
            "Tablet",
            "Smartphone"
          ]
        },
        "owner": {
          "type": "string",
          "description": "ID of the person who owns this asset"
        },
        "purchaseDate": {
          "type": "string",
          "format": "date",
          "description": "Date when this asset was purchased"
        }
      }
    },
    "AssetResponse": {
      "type": "object",
      "properties": {
        "message": {
          "type": "string"
        },
        "content": {
          "$ref": "#/definitions/Asset"
        }
      }
    }
  }
}