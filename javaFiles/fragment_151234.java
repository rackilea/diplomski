import com.google.gson.Gson;


public class MemTest {
    public static void main(String[] args) {
        String json = "{'member':[{'id':585897,'name':'PhPeter','profileIconId':691,'age':99,'email':‌​‌​'peter@adress.com'},{'id':645231,'name':'Bill','profileIconId':123,'age':56,'em‌​ai‌​l':'bill@adress.com'}]}";
        MemberClass memberClass = new Gson().fromJson(json, MemberClass.class);

        System.out.println(new Gson().toJson(memberClass));
    }
}