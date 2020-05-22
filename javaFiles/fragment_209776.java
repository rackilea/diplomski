package com.company.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.company.ParentBogus;
import com.company.testjar.Bogus;
import com.company.testjar.TestClass;
import com.company.testjar.subpackage.SubBogus;
import com.company.testjar2.TestClass2;

/**
 * A set of tests for testing the effects of .jar sealing.
 * 
 * These tests rely on a built .jar named TestJar.jar which is built from the command line.
 * 
 * Only one of these tests can be run at a time because one a package has been loaded, it cannot
 * be unloaded again. Because of this, each test must be run separately.
 */
public class TestPackages {

    @Test
    public void SealedFail1() {
        // Instantiate instance of TestClass from sealed .jar.
        TestClass t = new TestClass();

        // Following should blow up because package com.company.testjar has already
        // been loaded by instantiating TestClass above.
        try {
            new Bogus();

            // Should not get here. Throw if we do.
            assertFalse(true);
        } catch (SecurityException ex) {
            // Expected.
        }
    }

    @Test
    public void SealedFail2() {
        Bogus b = new Bogus();

        // Following should blow up because package com.company.testjar has already
        // been loaded by instantiating Bogus above.
        try {
            new TestClass();

            // Should not get here. Throw if we do.
            assertFalse(true);
        } catch (SecurityException ex) {
            // Expected.
        }
    }

    /**
     * Test to see if instantiating object from package in a sealed .jar will effectively
     * load and seal all packages in that .jar.
     */
    @Test
    public void SealedFail3() {
        // Instantiate object from com.company.testjar2 package. This package will now be
        // loaded and sealed.
        TestClass2 t2 = new TestClass2();

        // Instantiate object from com.company.testjar package NOT from sealed .jar.
        // This should work because this package has not been sealed yet!
        Bogus b = new Bogus();

        // This should now throw because the com.company.testjar package has already
        // been loaded by instantiating Bogus above, and the TestClass is from that
        // same package from the sealed .jar.
        try {
            new TestClass();

            // Should not get here. Throw if we do.
            assertFalse(true);
        } catch (SecurityException ex) {
            // Expected.
        }
    }

    /**
     * Test to see if instantiating an object from a sealed .jar prevents us from then
     * instantiating an instance of an object from a sub-package NOT defined in the
     * same .jar.
     */
    @Test
    public void SubPackage() {
        // Instantiate instance of TestClass from sealed .jar. Loads and seals the
        // com.company.testjar package.
        TestClass t = new TestClass();

        // Now attempt to instantiate an instance of an object from a sub-package of
        // com.company.testjar which is not defined in the same .jar.
        new SubBogus();
    }

    /**
     * Test to see if instantiating an object from a sealed .jar prevents us from then
     * instantiating an instance of an object from a parent package NOT defined in the
     * same .jar.
     */
    @Test
    public void ParentPackage() {
        // Instantiate instance of TestClass from sealed .jar. Loads and seals the
        // com.company.testjar package.
        TestClass t = new TestClass();

        // Now attempt to instantiate an instance of an object from the parent-package of
        // com.company.testjar which is not defined in the same .jar.
        new ParentBogus();
    }
}