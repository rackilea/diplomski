// Map<String, EnumMap<Connection, SimpleEntry<Label, CheckBox>>>
mWidgetInfo = new HashMap() {{
    put("service1", new EnumMap(Connection.class) {{
        put(Connection.Connection1, new SimpleEntry<>(mService1Label1, mService1CheckBox1));
        put(Connection.Connection2, new SimpleEntry<>(mService1Label2, mService1CheckBox2));
        put(Connection.Connection3, new SimpleEntry<>(mService1Label3, mService1CheckBox3));
        put(Connection.Connection4, new SimpleEntry<>(mService1Label4, mService1CheckBox4));
    }});
    put("service2", new EnumMap(Connection.class) {{
        put(Connection.Connection1, new SimpleEntry<>(mService2Label1, mService2CheckBox1));
        put(Connection.Connection2, new SimpleEntry<>(mService2Label2, mService2CheckBox2));
        put(Connection.Connection3, new SimpleEntry<>(mService2Label3, mService2CheckBox3));
        put(Connection.Connection4, new SimpleEntry<>(mService2Label4, mService2CheckBox4));
    }});
    put("service3", new EnumMap(Connection.class) {{
        put(Connection.Connection1, new SimpleEntry<>(mService3Label1, mService3CheckBox1));
        put(Connection.Connection2, new SimpleEntry<>(mService3Label2, mService3CheckBox2));
        put(Connection.Connection3, new SimpleEntry<>(mService3Label3, mService3CheckBox3));
        put(Connection.Connection4, new SimpleEntry<>(mService3Label4, mService3CheckBox4));
    }});
}};