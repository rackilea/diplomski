String jarray = "[" +
                "{id: '1', priorty_seq: '10', row_id: '100'}," +
                "{id: '2', priorty_seq: '20', row_id: '200'}," +
                "{id: '3', priorty_seq: '30', row_id: '300'}" +
                "]";
Type type = new TypeToken<Collection<JavaBean>>() {}.getType();
Collection<JavaBean> result = new Gson().fromJson(jarray, type);