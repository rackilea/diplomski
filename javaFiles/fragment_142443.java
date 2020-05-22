IntegrationFlow flow = f -> 
          IntegrationFlows.from(
               Jms.messageDriverChannelAdapter(this.connectionFactory)
                    .destination(aDestinationName))
                 .channel(channelToSend)
                 get();

    IntegrationFlowRegistration theFlow = this.flowContext.registration(flow).register();