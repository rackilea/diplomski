public class WorKCompletionForms {
    private String id;
    private String name;
    // getters and setters
}

WokCompletionForms[] s = p.get_work_completion_forms();
for (int i = 0; i < s.length;i++){
    Log.d("TAG", s[i].getId());
}