// get random content data
            Integer contentAmmount = response.body().path("Contents.Contents.size()");
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(contentAmmount);
            while (response.body().path(
                    String.join("", "Contents.Contents[", Integer.toString(randomInt), 
                            "].children_uuids.item")).toString().isEmpty() ) {
                randomInt = randomGenerator.nextInt(contentAmmount);
            }

            String contentTitle = response.then().extract()
                    .path(String.join("", "Contents.Contents[", Integer.toString(randomInt), "].title"));
            String contentUuid = response.then().extract()
                    .path(String.join("", "Contents.Contents[", Integer.toString(randomInt), "].uuid"));
            String contentChildrenUuid = response.body().path(
                    String.join("", "Contents.Contents[", Integer.toString(randomInt), 
                            "].children_uuids.item"));