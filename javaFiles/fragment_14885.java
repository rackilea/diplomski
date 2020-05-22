enum datatype
{
    dt_none,
    dt_char,
    dt_uchar,
    dt_short,
    dt_ushort,
    dt_long,
    dt_ulong,
    dt_float,
    dt_double
};

struct Any
{
      datatype type; // To know what is stored inside union, not mandatory if you know that in another way
      union
      {
          char vchar;
          unsigned char vuchar;
          short vshort;
          unsigned short vushort;
          long vlong;
          unsigned long vulong;
          float vfloat;
          double vdouble;
      } data;
};

std::vector<Any> mydata;