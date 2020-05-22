state = 0;
while( (byte=input.read()) != EOF)
{
    switch(state)
    {
        case 0:     // "normal" state
            if (byte == 0x00)
            {
                state = 1;
                buf.append(byte);
            }
            else
                output.write(byte)
            break;
        case 1:     // We've seen a 0x00
            if (byte == 0x00)
            {
                state = 1;
                output.write(buf);
            }
            else if (byte == 0x01)
            {
                state = 2;
                buf.append(byte);
            }
            else
            {
                output.write(buf);
                buf.clear();
                state = 0;
            }
            break;
        case 2:     // We've seen 0x00,0x01
            if (byte == 0x00)
            {
                state = 3;
                buf.append(byte);
            }
            else if (byte == 0x01)
            {
                output.write(0x00);
                buf.clear();
                state = 0;
            }
            else
            {
                output.write(buf);
                buf.clear();
                state = 0;
            }
            break;
        case 3:     // We've seen 0x00,0x01,0x00
            if (byte == 0x00)
            {
                state = 1;
                output.write(buf);
                buf.clear();
                buf.append(byte);
            }
            else if (byte == 0x01)
            {
                // The last four input bytes were 0x00,0x01,0x00,0x01
                state = 0;
                output.write(0x00,0x00);
                buf.clear
            }
            else
            {
                output.write(buf);
                buf.clear();
                state = 0;
            }
            break;
    }
}
if (!buf.empty()) output.write(buf);