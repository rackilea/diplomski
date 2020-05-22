package com.greenrobot.yesorno.test;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;
import android.test.suitebuilder.annotation.LargeTest;

import com.greenrobot.yesorno.Home;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import com.greenrobot.yesorno.R;


/**
 * Created by andytriboletti on 1/15/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestLogin  {

    private UiDevice mDevice;

    private static final String PACKAGE_NAME = "com.greenrobot.yesorno";
    private static final int LAUNCH_TIMEOUT = 5000;

    @Rule
    public ActivityTestRule<Home> mActivityRule = new ActivityTestRule(Home.class);

    public TestLogin() {
        super();
    }

    @Before
    public void initTest() {
        // Initialize UiDevice instance     
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher     
        String launcherPackage = mDevice.getCurrentPackageName();
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        // Launch the app     
        Context context = InstrumentationRegistry.getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(PACKAGE_NAME);

        // Clear out any previous instances     
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear     
        mDevice.wait(Until.hasObject(By.pkg(PACKAGE_NAME).depth(0)), LAUNCH_TIMEOUT);
    }

    @Test
    public void testLogin() {
        onView(withId(R.id.welcome)).check(matches(isDisplayed()));

//        onView(withText("Hello world!")).check(matches(isDisplayed()));

        //onView(withId(R.id.changeTextBt)).perform(click());

    }
}