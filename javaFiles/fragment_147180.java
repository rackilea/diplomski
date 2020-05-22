JSONObject jsonMessage = new JSONObject();
jsonMessage.put(DEFAULT, "foo");
jsonMessage.put(HTTPS, someOtherJsonObject.toString());
jsonMessage.put(HTTP, someOtherJsonObject.toString());

PublishRequest publishRequest = new PublishRequest(topicArn, jsonMessage.toString());
publishRequest.setMessageStructure(MESSAGE_TYPE_JSON);
amazonSNSClient.publish(publishRequest);