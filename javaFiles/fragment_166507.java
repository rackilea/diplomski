Binding binding = client.getEndpoint().getBinding();
        BindingInfo bindingInfo = binding.getBindingInfo();

        Collection<BindingOperationInfo> operations = bindingInfo
                .getOperations();

        for (BindingOperationInfo boi : operations) {
            BindingMessageInfo inputMessageInfo = boi.getInput();
            List<MessagePartInfo> parts = inputMessageInfo
                    .getMessageParts();

            System.out.println("method name: "
                    + parts.get(0).getConcreteName().getLocalPart());

            for (Field param : parts.get(0).getTypeClass()
                    .getDeclaredFields()) {
                System.out.println("param_name: " + param.getName()
                        + " type:" + param.getType());
            }

        }