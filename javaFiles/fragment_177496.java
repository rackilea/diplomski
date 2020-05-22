fun cancelSubscription(cancelStripeSubscription: CancelStripeSubscription): Subscription? =
    try {
        Subscription.retrieve("superSecret").cancel(null)
    } catch (ex: StripeException) {
        null
    }