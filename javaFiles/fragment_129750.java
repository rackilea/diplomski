String TYPE = "type";
long TOTAL_MASK = 0xFFFFFFFF;
long BASE_INBOX_TYPE = ~20; // (~)promotion to int first (not necessary)
long BASE_TYPE_MASK = 0x1F;

long type = (TOTAL_MASK - BASE_TYPE_MASK) | BASE_INBOX_TYPE;

System.out.println(type);