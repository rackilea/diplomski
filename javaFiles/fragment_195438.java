}

/**
 * Tests wheel value
 * 
 * @param id
 *            the wheel Id
 * @param value
 *            the value to test
 * @return true if wheel value is equal to passed value
 */
private int testWheelValue(int id, int value) {
    int wheel = getWheel(id).getCurrentItem();
    wheel = value;