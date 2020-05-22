import java.util.*;

public class test 
{

    public static void ReadHoldRegisters(List<Integer> lst, int deviceaddr, int RegisterAddress, int RegisterLength)
    {
        lst.add(deviceaddr & 0xff);
        lst.add(6);
            lst.add((RegisterAddress >> 8) & 0xff);
            lst.add(RegisterAddress & 0xff);
            lst.add((RegisterLength >> 8) & 0xff);
            lst.add(RegisterLength & 0xff);
        Add_CRC16(lst);
    }

    private static void Add_CRC16(List<Integer> Data)
    {
        int SaveLo, SaveHi;
        int CRC16Lo = 0xFF;
        int CRC16Hi = 0xff;
        int CL      = 0x1;
        int CH      = 0xA0;

        for (int b : Data)
        {
            CRC16Lo ^= b;

            for (int flag=0; flag<8; flag++)
            {
                SaveHi = CRC16Hi;
                SaveLo = CRC16Lo;

                CRC16Hi = CRC16Hi/2;
                CRC16Lo = CRC16Lo/2;

                if((SaveHi & 0x01) == 0x01)
                    CRC16Lo |= 0x80;

                if((SaveLo & 0x01) == 0x01)
                {
                    CRC16Hi ^= CH;
                    CRC16Lo ^= CL;
                }
            }

        }

        Data.add(CRC16Lo & 0xff);
        Data.add(CRC16Hi & 0xff);
    }

    public static void main(String[] args) 
    {
        List<Integer> lst = new ArrayList<Integer>();
        ReadHoldRegisters(lst, 1, 1, 10);
        for (int value: lst)
        {
            System.out.print(String.format("%02x", value));
            System.out.print(" ");
        }
    }

}