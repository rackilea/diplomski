return jobs.get("delivery")
           .preventRestart()
           .listener(failedCleanupListener)
           .flow(firstStep)
           .next(deliveryStep)
           .next(handleSentStep)
           .end()
           .build();