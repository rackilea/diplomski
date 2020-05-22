package com.example;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.dev.HighRepJobPolicy;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

public class BaseTest {
  public static final class Policy implements HighRepJobPolicy {
    static boolean shouldApply = false;

    public static void applyAll() {
      shouldApply = true;
    }

    public static void applyNone() {
      shouldApply = false;
    }

    @Override
    public boolean shouldApplyNewJob(Key entityGroup) {
      return shouldApply;
    }

    @Override
    public boolean shouldRollForwardExistingJob(Key entityGroup) {
      return shouldApply;
    }
  }

  public final LocalServiceTestHelper helper =
      new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig()
          .setAlternateHighRepJobPolicyClass(Policy.class));

  @Before
  public void setUp() {
    helper.setUp();
  }

  @After
  public void tearDown() {
    helper.tearDown();
  }
}