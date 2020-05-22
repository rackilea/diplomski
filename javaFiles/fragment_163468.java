if (speechletRequestEnvelope.getRequest().getDialogState() != IntentRequest.DialogState.COMPLETED)
        // 1. Create DialogIntent based on your original intent
        DialogIntent dialogIntent = new DialogIntent(speechletRequestEnvelope.getRequest().getIntent());

        // 2. Create Directive
        DelegateDirective dd = new DelegateDirective();
        dd.setUpdatedIntent(dialogIntent);

        List<Directive> directiveList = new ArrayList<>();
        directiveList.add(dd);

        SpeechletResponse speechletResp = new SpeechletResponse();
        speechletResp.setDirectives(directiveList);
        // 3. return the response.
        speechletResp.setNullableShouldEndSession(false);
        return speechletResp;
    }