package src.com;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
public class Abc {      
    public static class Bean {
        int token;
        Object obj;
        public Bean(){}
        public Bean(int token, Object o) {
            super();
            this.token = token;
            this.obj = o;
        }
    }
    public static void main(String[] args) {
        String input = "{{a,b,c},4, 6,7,{d,e,{},{ }}}";
        input = input.replaceAll(" ", "");
        List<Object> list = getList(input);
        System.out.println(list);
    }
    @SuppressWarnings("unchecked")
    public static List<Object> getList(String input1) {
        Deque<Object> stack = new ArrayDeque<Object>();
        char[] chararray = input1.toCharArray();
        String temp = "";
        for (int i = 0; i < chararray.length; i++) {
            if (chararray[i] == '}') {
                if (!temp.equals("")) {
                    stack.push(new Bean(0, temp));
                    temp = "";
                }
                List<Object> tmplist = new ArrayList<>();
                while (true) {
                    Object object = stack.pop();
                    if (object instanceof Bean) {
                        Bean b = (Bean) object;
                        if (b.token == 1)
                            break;
                        tmplist.add(b.obj);
                    } else {
                        tmplist.add(object);
                        if (stack.isEmpty())
                            break;
                    }
                }
                Collections.reverse(tmplist);
                stack.push(tmplist);
            } else {
                if (chararray[i] == '{') {
                    stack.push(new Bean(1, Character.toString(chararray[i])));
                } else if (chararray[i] == ',') {
                    if (!temp.equals("")) {
                        stack.push(new Bean(0, temp));
                        temp = "";
                    }
                } else {
                    temp = temp + Character.toString(chararray[i]);
                }
            }
        }
        return (List<Object>) stack.pop();
    }
}