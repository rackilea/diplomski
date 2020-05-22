D V00001          DS                  OCCURS(64)
 D  F0000G                       20A
 D  F0000H                       10A
 D  F0000I                       10A
 D  F0000J                       20A
 D  F0000K                        9p 0
 D  F0000L                        1A
 D  F0000M                       20A
 D  F0000N                       10A
 D  F0000O                       10A
 D  F0000P                       20A
 D  F0000Q                       10A
 D  F0000R                        1A
 D  F0000S                       10A

 c     *entry        plist
 c                   parm                    v00001

   // populate the first entry
   %occur(v00001) = 1;
   F0000G = *ALL'1234567890';
   F0000H = *ALL'A';
   F0000I = *ALL'B';
   F0000J = *ALL'C';
   F0000K = 123456789;
   F0000L = *ALL'E';
   F0000M = *ALL'F';
   F0000N = *ALL'G';
   F0000O = *ALL'H';
   F0000P = *ALL'I';
   F0000Q = *ALL'J';
   F0000R = *ALL'K';
   F0000S = *ALL'a';

   // populate the 2nd entry
   %occur(v00001) = 2;
   F0000G = *ALL'1234567890';
   F0000H = *ALL'1234567890';
   F0000I = *ALL'1234567890';
   F0000J = *ALL'1234567890';
   F0000K = 200;
   F0000L = *ALL'1234567890';
   F0000M = *ALL'1234567890';
   F0000N = *ALL'1234567890';
   F0000O = *ALL'1234567890';
   F0000P = *ALL'1234567890';
   F0000Q = *ALL'1234567890';
   F0000R = *ALL'1234567890';
   F0000S = *ALL'b';

   // populate the third entry
   %occur(v00001) = 3;
   F0000G = *ALL'1234567890';
   F0000H = *ALL'1234567890';
   F0000I = *ALL'1234567890';
   F0000J = *ALL'1234567890';
   F0000K = 300;
   F0000L = *ALL'1234567890';
   F0000M = *ALL'1234567890';
   F0000N = *ALL'1234567890';
   F0000O = *ALL'1234567890';
   F0000P = *ALL'1234567890';
   F0000Q = *ALL'1234567890';
   F0000R = *ALL'1234567890';
   F0000S = *ALL'c';

   // reset back to the beginning
   %occur(v00001) = 1;
   dump(a);

   *inlr = *on;