package package1;

public class Solution {
    public Data returnValue(Data input) {
        Data data = new Data();
        data.s = input.s + "append";
        data.a1 = input.a1 + 1;
        data.a2 = input.a2 + 2;

        return data;
    }
}