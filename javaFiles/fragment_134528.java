final String input = "[01:07]bbbbbbb[00:48]aaaaaa[01:36]ccccccccc[03:45]gggggggg[03:31]fffffff[01:54]ddddddddd[02:09]eeeeeee[03:59]hhhhhhhh";
final String entries[] = input.split("(?=\\[)");
Arrays.sort(entries);

String res = "";
for (final String entry : entries) {
    res += entry;
}

System.out.println(res);