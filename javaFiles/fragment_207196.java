public static void main(String[] args) {

        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Member.json"));

            Object obj = gson.fromJson(br, Object.class);
            if (obj instanceof Map) {
                @SuppressWarnings("unchecked")
            Map<String,Object> map = (Map<String,Object>) obj;
            Collection<Object> coll = map.values();
            Iterator<Object> iter = coll.iterator();
                while (iter.hasNext()) {
                    Object str = iter.next();

                    StringReader sr = new StringReader(str.toString());
                    Member memberObj = gson.fromJson(sr, Member.class);
                    System.out.println("Id: " + memberObj.getId());
                    System.out.println("Name: " + memberObj.getName());
                    System.out.println("ProfileIconID: "
                            + memberObj.getProfileIconId());
                    System.out.println("Age: " + memberObj.getAge());
                    System.out.println("Email: " + memberObj.getEmail());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }