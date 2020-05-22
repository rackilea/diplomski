ArgumentCaptor<String> routingKeyCaptor = ArgumentCaptor.forClass(String.class);
ArgumentCaptor<Object> messageCaptor = ArgumentCaptor.forClass(Object.class);

...

verify(rabbitTemplate).convertAndSend(routingKeyCaptor.capture(), messageCaptor.capture(), any(MessagePostProcessor.class));