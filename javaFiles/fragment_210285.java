package com.example.helloworld.resources;

import com.example.helloworld.auth.SimpleAuthenticator;
import com.example.helloworld.core.Saying;
import com.example.helloworld.core.User;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.HttpHeaders;

public class SecureHelloWorldResourceTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @ClassRule
    public static final ResourceTestRule resources =
            ResourceTestRule.builder()
                    .setTestContainerFactory(new GrizzlyWebTestContainerFactory())
                    .addProvider(AuthFactory.binder(new BasicAuthFactory<User>(new SimpleAuthenticator(),
                            "Authentication Realm",
                            User.class)))
                    .addResource(new HelloWorldResource("Hey There %s", "DefaultName"))
                    .build();

    @Test
    public void testAuthorizedRequest() {
        Saying result = resources
                .getJerseyTest()
                .target("/hello-world/secure")
                .request()
                .header(HttpHeaders.AUTHORIZATION, "Basic Z29vZC1ndXk6c2VjcmV0").get(Saying.class);//good-guy:secret

        Assert.assertEquals("Hey There good-guy", result.getContent());
    }

    @Test
    public void testDeniedRequest() {
        exception.expect(NotAuthorizedException.class);
        resources
                .getJerseyTest()
                .target("/hello-world/secure")
                .request()
                .header(HttpHeaders.AUTHORIZATION, "Basic YmFkLWd1eTpwYXNzd29yZA==").get(Saying.class);//bad-guy:password


    }
}