"sort": [
        {
          "bulkOrders.expiryDate": {
            "order": "asc",
            "nested": {
              "path": "bulkOrders"
            }
          }
        }
      ]