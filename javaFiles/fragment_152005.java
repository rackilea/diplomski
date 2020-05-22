public class Solution {
    public void compareStudents(Student left, Student right, Counter counter) throws Exception {
        for (Field field : Student.class.getDeclaredFields()) {
            Object leftValue = field.get(left);
            Object rightValue = field.get(right);

            String fieldName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);

            if(leftValue != null && rightValue != null) {
                Field counterField = Counter.class.getDeclaredField("bothStudentsHave" + fieldName);
                counterField.set(counter, (long) counterField.get(counter) + 1);
            } else if (leftValue != null) {
                Field counterField = Counter.class.getDeclaredField("onlyLeftHas" + fieldName);
                counterField.set(counter, (long) counterField.get(counter) + 1);
            } else if (rightValue != null) {
                Field counterField = Counter.class.getDeclaredField("onlyRightHas" + fieldName);
                counterField.set(counter, (long) counterField.get(counter) + 1);
            }
        }
    }
}