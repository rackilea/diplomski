match = {$match: {
         "meta.active": true,
         "meta.client.id": 1,
         "data.attributes.lang": "en",
         "data.attributes.geo": "us"
        }