private static void retrieveBytes(byte[] bytes)
        {
            int size= bytes.length;

            for(int i=0; i< size; i++)
            {
                byte1= 0;
                for(int j=6; j>=0; j-=2)
                {
                    byte2= byteArrayIn[inputOutputMarker];
                    inputOutputMarker++;

                    byte2&= 0x03;
                    byte2<<= j;
                    byte1|= byte2;
                }
                bytes[i]= byte1;
            }
        }