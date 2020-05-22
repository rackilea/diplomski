package io.mirko.lambda;

import com.amazon.ask.AlexaSkill;
import com.amazon.ask.Skills;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.RequestEnvelope;
import com.amazon.ask.model.ResponseEnvelope;
import com.amazon.ask.request.interceptor.GenericRequestInterceptor;
import io.mirko.lambda.handlers.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;
import java.util.stream.StreamSupport;


public class SkillFactory {
    @Inject
    Instance<RequestHandler> handlers;

    @Produces
    @ApplicationScoped
    @Named
    public AlexaSkill<RequestEnvelope, ResponseEnvelope> createSkill() {
        return Skills.standard()
                .addRequestHandlers(handlers.stream().toArray(RequestHandler[]::new))
                .addRequestInterceptor(new GenericRequestInterceptor<HandlerInput>() {
                    @Override
                    public void process(HandlerInput handlerInput) {
                        System.out.format("Processing %s\n", handlerInput.getRequest());
                    }
                })
                // Add your skill id below
                //.withSkillId("")
                .build();
    }
}

...

public class SwearStreamLambda extends SkillStreamHandler {
    @Named("swearStream")
        public SwearStreamLambda() {
            //noinspection unchecked
            super((AlexaSkill<RequestEnvelope, ResponseEnvelope>)
                getBean(new ParameterizedTypeImpl(AlexaSkill.class, RequestEnvelope.class, ResponseEnvelope.class)));