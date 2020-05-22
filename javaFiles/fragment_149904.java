@interface enums
    // here, the enum and its values are in the same place.

    typedef enum {eRED, eGREEN, eBLUE} ColorEnum;
    #define kColourValue  { 0xFF0000, 0x00FF00, 0x0000FF }
    extern int colourValues[];
@end