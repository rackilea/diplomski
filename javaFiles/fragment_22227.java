package com.example;

import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.TopicName;

import com.google.protobuf.util.Durations;

import java.io.IOException;

public class PubSubCreateSubscription {

    static Subscription createSubscriptionWithMessageRetentionDuration(
        String topicName,
        String subscriptionName,
        long messageRetentionDurationInMillis
    ) throws IOException {
        try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
            Subscription request = Subscription.newBuilder()
                .setName(subscriptionName)
                .setTopic(topicName)
                .setMessageRetentionDuration(Durations
                    .fromMillis(messageRetentionDurationInMillis))
                .build();

            return subscriptionAdminClient
                .createSubscription(request);
        }
    }

    public static void main(String[] args)
    {
        String topicName = "projects/[PROJECT]/topics/[TOPIC_NAME]";
        String subscriptionName = "projects/[PROJECT]/subscriptions/[SUBSCRIPTION_NAME]";

        try {
            Subscription mySubscription = createSubscriptionWithMessageRetentionDuration(
                topicName,
                subscriptionName,
                600000 // 600 000 ms = 10 minutes
            );
            // [...]
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}