int CRC16(char puchMsg, int usDataLen)
  {
     char uchCRCHi = 0xFF ; /* high byte of CRC initialized */
     char uchCRCLo = 0xFF ; /* low byte of CRC initialized */
     int uIndex ; /* will index into CRC lookup table */

     // Correction 1: compare the int to 0
     while (usDataLen-- > 0) /* pass through message buffer */
     {
      uIndex = uchCRCHi ^ puchMsg++ ; /* calculate the CRC */
      uchCRCHi = (char) (uchCRCLo ^ auchCRCHi[uIndex]); // Correction 2: explicit ca
      uchCRCLo = auchCRCLo[uIndex] ;
     }

    return (uchCRCHi << 8 | uchCRCLo) ;
    }