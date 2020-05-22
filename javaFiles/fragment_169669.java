{
    "_embedded": {
        "recipes": [
            {
                "name": "Coffee Stout",
                "resourceId": 1,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/recipes/1"
                    },
                    "recipe": {
                        "href": "http://localhost:8080/api/recipes/1"
                    },
                    "user": {
                        "href": "http://localhost:8080/api/recipes/1/user"
                    },
                    "ingredients": {
                        "href": "http://localhost:8080/api/recipes/1/ingredients"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/recipes{?page,size,sort}",
            "templated": true
        },
        "profile": {
            "href": "http://localhost:8080/api/profile/recipes"
        }
    },
    "page": {
        "size": 5,
        "totalElements": 1,
        "totalPages": 1,
        "number": 0
    }
}