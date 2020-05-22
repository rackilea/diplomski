try (CallableStatement call = c.prepareCall(
    "declare "
  + "  num integer := 1000;" // Adapt this as needed
  + "begin "

  // You have to enable buffering any server output that you may want to fetch
  + "  dbms_output.enable();"

  // This might as well be a call to third-party stored procedures, etc., whose
  // output you want to capture
  + "  dbms_output.put_line('abc');"
  + "  dbms_output.put_line('hello');"
  + "  dbms_output.put_line('so cool');"

  // This is again your call here to capture the output up until now.
  // The below fetching the PL/SQL TABLE type into a SQL cursor works with Oracle 12c.
  // In an 11g version, you'd need an auxiliary SQL TABLE type
  + "  dbms_output.get_lines(?, num);"

  // Don't forget this or the buffer will overflow eventually
  + "  dbms_output.disable();"
  + "end;"
)) {
    call.registerOutParameter(1, Types.ARRAY, "DBMSOUTPUT_LINESARRAY");
    call.execute();

    Array array = null;
    try {
        array = call.getArray(1);
        System.out.println(Arrays.asList((Object[]) array.getArray()));
    }
    finally {
        if (array != null)
            array.free();
    }
}