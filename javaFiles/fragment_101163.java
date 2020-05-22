package com.blogspot.javarestlet.httpbasicauth.server.app;

import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.data.ChallengeScheme;
import org.restlet.routing.Router;
import org.restlet.security.ChallengeAuthenticator;
import org.restlet.security.MapVerifier;

import com.blogspot.javarestlet.httpbasicauth.server.resources.HelloWorldAdminServerResource;
import com.blogspot.javarestlet.httpbasicauth.server.resources.HelloWorldDefaultServerResource;

public class AdminAppStart extends Application {
    private ChallengeAuthenticator authenticator;

    private ChallengeAuthenticator createAuthenticator() {
        Context context = getContext();
        final boolean optional = false;
        ChallengeScheme challengeScheme = ChallengeScheme.HTTP_BASIC;
        String realm = "Example site";

        MapVerifier verifier = new MapVerifier();
        verifier.getLocalSecrets().put("scott", "tiger".toCharArray());

        ChallengeAuthenticator auth = new ChallengeAuthenticator(context, optional, challengeScheme, realm, verifier);
        return auth;
    }

    @Override
    public Restlet createInboundRoot() {
        this.authenticator = createAuthenticator();

        Router router = new Router();
        router.attach("/user", HelloWorldAdminServerResource.class);
        router.attach("", HelloWorldDefaultServerResource.class);

        authenticator.setNext(router);
        return authenticator;
    }

}