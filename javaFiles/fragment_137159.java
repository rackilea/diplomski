package test;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.cloudtrace.v1.CloudTrace;
import com.google.api.services.cloudtrace.v1.CloudTraceScopes;
import com.google.api.services.cloudtrace.v1.model.Trace;
import com.google.api.services.cloudtrace.v1.model.TraceSpan;
import com.google.api.services.cloudtrace.v1.model.Traces;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

        GoogleCredential cred = GoogleCredential
                .fromStream(
                        new FileInputStream("/path/to/secrets.json"),
                        httpTransport,
                        jsonFactory)
                .createScoped(Collections.singletonList(CloudTraceScopes.TRACE_APPEND));

        CloudTrace gceTrace = new CloudTrace.Builder(httpTransport, jsonFactory, cred)
                .setApplicationName("Google Cloud Trace test app")
                .build();

        // They are optional
        Map<String, String> labels = new HashMap<>();
        labels.put("key1", "val1");

        TraceSpan span = new TraceSpan();
        span.setSpanId(new BigInteger("1")); // Mandatory
        span.setName("test"); // Optional
        span.setKind("RPC_SERVER"); // Optional
        span.setStartTime("2016-08-04T01:00:00Z"); // Optional
        span.setEndTime("2016-08-04T01:00:01Z"); // Optional
        span.setLabels(labels); // Optional
        Trace trace = new Trace();
        trace.setProjectId("myprojectid"); // Mandatory
        trace.setTraceId("A096D4956A424EEB98AE7863505B1E1F"); // Mandatory
        trace.setSpans(Collections.singletonList(span)); // Mandatory
        Traces traces = new Traces();
        traces.setTraces(Collections.singletonList(trace)); // Mandatory
        gceTrace.projects().patchTraces("myprojectid", traces).execute();
    }

}