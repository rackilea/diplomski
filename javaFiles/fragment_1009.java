int[] actualArray = {0x9A, 0xBC, 0xDE, 0xF0, 0x12, 0x34};
int[] expectedArray = new int[actualArray.length - 1];

for (int i = 0; i < expectedArray.length; ++i)
{
    expectedArray[i] = (actualArray[i] << 4) & 0xF0 | (actualArray[i + 1] >> 4) & 0x0F;
}