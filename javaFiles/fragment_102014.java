rest("/exampleCallback").description("ExampleCallBackUri")
          .get()
          .bindingMode(RestBindingMode.off)
          .param().name(abc).type(RestParamType.query).required(true).endParam()
          .param().name(xyz).type(RestParamType.query).required(true).endParam() 
          .produces(MediaType.TEXT_PLAIN_VALUE)
          .toD("someIntermediateEndpoint");

from("someIntermediateEndpoint")
          .process(messageProcessor).id("MessageProcessor")
          .to(exampleEndpoint);