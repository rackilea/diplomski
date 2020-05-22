public static void updateGroupName(int count) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("your table name").child(" table child name ");
        try {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("count", count);
            reference.updateChildren(hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }