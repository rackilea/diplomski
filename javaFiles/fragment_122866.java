void mc6809::help_adc(Byte& x)
{
    Byte    m = fetch_operand();

    {
        Byte    t = (x & 0x0f) + (m & 0x0f) + cc.bit.c;
        cc.bit.h = btst(t, 4);          // Half carry
    }

    {
        Byte    t = (x & 0x7f) + (m & 0x7f) + cc.bit.c;
        cc.bit.v = btst(t, 7);          // Bit 7 carry in
    }

    {
        Word    t = x + m + cc.bit.c;
        cc.bit.c = btst(t, 8);          // Bit 7 carry out
        x = t & 0xff;
    }

    cc.bit.v ^= cc.bit.c;
    cc.bit.n = btst(x, 7);
    cc.bit.z = !x;
}