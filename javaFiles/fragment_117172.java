# retrieve all dogs
curl -X GET "http://localhost:8080/dogs"

# post dog
curl -X POST -H "Content-Type: application/json" -d '{
    "breedType": "Husky",
    "imgUrl": "http://i.imgur.com/abc123.png",
    "likes": 0
}' "http://localhost:8080/dogs"

# like dog
curl -X POST -H "Content-Type: application/json" -d '' http://localhost:8080/dogs/likeDog/<dogs-id>"