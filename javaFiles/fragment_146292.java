public static void main(String[] args)
    {
        String str = "{ \"foo\": \"bar\", \"key\": true, \"otherKey\": 10 }";
        try (InputStream is = new ByteArrayInputStream(str.getBytes("UTF-8")))  {
            Map<String, ?> map = new ObjectMapper().readValue(is, Map.class);
            // print map contents
            System.out.println(map);
            // print type of map values
            System.out.print(entry.getKey() + "=" + entry.getValue().getClass()+ ", "));
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }