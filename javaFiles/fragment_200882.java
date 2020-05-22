try (Connection c = DriverManager.getConnection(url, properties);
     Statement s = c.createStatement()) {

    try {
        s.executeUpdate("begin dbms_output.enable(); end;");
        s.executeUpdate("begin dbms_output.put_line('abc'); end;");
        s.executeUpdate("begin dbms_output.put_line('hello'); end;");
        s.executeUpdate("begin dbms_output.put_line('so cool'); end;");

        try (CallableStatement call = c.prepareCall(
            "declare "
          + "  num integer := 1000;"
          + "begin "
          + "  dbms_output.get_lines(?, num);"
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
    }
    finally {
        s.executeUpdate("begin dbms_output.disable(); end;");
    }
}