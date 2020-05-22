package cruft;

import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test demonstrates testing equals and hashcode contract
 * Created by Michael
 * Creation date 1/16/2016.
 * @link https://stackoverflow.com/questions/34826585/hashcode-changes-each-time-the-object-is-created
 */
public class OverrideDemoTest {

    @Test
    public void testEquals_Null() {
        OverrideDemo x = new OverrideDemo(5, SquareType.EARTH);
        Assert.assertFalse(x.equals(null));
    }

    @Test
    public void testEquals_Reflexive() {
        OverrideDemo x = new OverrideDemo(5, SquareType.EARTH);
        Assert.assertTrue(x.equals(x));
    }

    @Test
    public void testEquals_Symmetric() {
        OverrideDemo x = new OverrideDemo(5, SquareType.EARTH);
        OverrideDemo y = new OverrideDemo(5, SquareType.EARTH);
        Assert.assertTrue(x.equals(y));
        Assert.assertTrue(y.equals(x));
        Assert.assertTrue(x.hashCode() == y.hashCode());
    }

    @Test
    public void testEquals_Transitive() {
        OverrideDemo x = new OverrideDemo(5, SquareType.EARTH);
        OverrideDemo y = new OverrideDemo(5, SquareType.EARTH);
        OverrideDemo z = new OverrideDemo(5, SquareType.EARTH);
        Assert.assertTrue(x.equals(y));
        Assert.assertTrue(y.equals(z));
        Assert.assertTrue(z.equals(x));
        Assert.assertTrue(x.hashCode() == y.hashCode());
        Assert.assertTrue(y.hashCode() == z.hashCode());
        Assert.assertTrue(z.hashCode() == x.hashCode());
    }

    @Test
    public void testEquals_DifferentDamage_NotEqual() {
        OverrideDemo x = new OverrideDemo(5, SquareType.EARTH);
        OverrideDemo y = new OverrideDemo(10, SquareType.EARTH);
        Assert.assertFalse(x.equals(y));
        Assert.assertFalse(y.equals(x));
        Assert.assertFalse(x.hashCode() == y.hashCode());
    }

    @Test
    public void testEquals_DifferentSquareType_NotEqual() {
        OverrideDemo x = new OverrideDemo(10, SquareType.EARTH);
        OverrideDemo y = new OverrideDemo(10, SquareType.FIRE);
        Assert.assertFalse(x.equals(y));
        Assert.assertFalse(y.equals(x));
        Assert.assertFalse(x.hashCode() == y.hashCode());
    }
}